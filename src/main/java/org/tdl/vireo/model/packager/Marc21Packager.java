package org.tdl.vireo.model.packager;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;

import org.apache.commons.io.FileUtils;
import org.tdl.vireo.model.Submission;
import org.tdl.vireo.model.export.ZipExportPackage;
import org.tdl.vireo.model.formatter.AbstractFormatter;

@Entity
public class Marc21Packager extends AbstractPackager<ZipExportPackage> {

    public Marc21Packager() {

    }

    public Marc21Packager(String name) {
        setName(name);
    }

    public Marc21Packager(String name, AbstractFormatter formatter) {
        this(name);
        setFormatter(formatter);
    }

    @Override
    public ZipExportPackage packageExport(Submission submission, Map<String, String> dsDocs) {

        Map<String, File> pkgs = new HashMap<String, File>();
        try {
            // Add non submitted content
            for (Map.Entry<String, String> ds_entry : dsDocs.entrySet()) {
                String docName = "Marc21/"+ds_entry.getKey()+"_"+submission.getId()+".mrc";
                String docContents = ds_entry.getValue();
                docContents = docContents.replace(System.lineSeparator(), "");
                File ff = File.createTempFile(docName, "");
                FileUtils.writeStringToFile(ff, docContents, StandardCharsets.UTF_8);
                pkgs.put(docName, ff);
            }
        } catch (IOException ioe) {
            throw new RuntimeException("Unable to generate package", ioe);
        }

        return new ZipExportPackage(submission, "text", pkgs);
    }
}
