[![Waffle.io - Columns and their card count](https://badge.waffle.io/TexasDigitalLibrary/Vireo.png?columns=all)](https://waffle.io/TexasDigitalLibrary/Vireo?utm_source=badge) [![Build Status](https://travis-ci.org/TexasDigitalLibrary/Vireo.svg?branch=master)](https://travis-ci.org/TexasDigitalLibrary/Vireo)

# Vireo 4
Vireo is a turnkey Electronic Thesis and Dissertation (ETD) Management System.  Starting with the 4.x release, Vireo offers fully customizable workflows and controlled vocabularies.  

The software is presently in a Beta release.  If you want to help with testing or development, GitHub issues and pull requests are encouraged!

## Building Vireo 4

### Development

```bash
$ mvn clean package
```

or run for development:

```bash
$ mvn clean spring-boot:run
```

or run for production

```bash
$ mvn clean spring-boot:run -Dproduction
```

### Production

```bash
$ mvn clean package -DskipTests -Dproduction -Dassets.uri=file://opt/vireo/
```
If all compile-time tests pass, you should have both a `vireo-4.0.0-SNAPSHOT.war` and a `vireo-4.0.0-SNAPSHOT-install.zip` in the `target/` directory.

#### Apache Reverse Proxy Config

```
LoadModule rewrite_module modules/mod_rewrite.so
LoadModule proxy_module modules/mod_proxy.so
LoadModule proxy_http_module modules/mod_proxy_http.so
LoadModule proxy_wstunnel_module modules/mod_proxy_wstunnel.so

<VirtualHost *:80>
  ServerName localhost

  ProxyPreserveHost On
  ProxyPass / http://127.0.0.1:8080/
  ProxyPassReverse / http://127.0.0.1:8080/
  ProxyRequests Off
  RewriteEngine on
  RewriteCond %{HTTP:UPGRADE} ^WebSocket$ [NC]
  RewriteCond %{HTTP:CONNECTION} Upgrade$ [NC]
  RewriteRule .* ws://localhost:8080%{REQUEST_URI} [P]

</VirtualHost>
```

## Testing Vireo 4

### Server

```bash
$ mvn clean test
```

### Client

```bash
$ npm run test
```

### Server and Client

```bash
$ mvn clean test -Dclient
```

### e2e

```bash
$ mvn clean spring-boot:run
$ npm run protractor
```

## Installing Zip Package to filesystem

Unzip package into preferred directory (or any directory you choose):

```bash
$ cd /opt/vireo
$ unzip ~/vireo-4.0.0-SNAPSHOT-install.zip
```

### Directory Structure of installed package

```bash
/opt/vireo$ ls
drwxr-xr-x 2 root root 4096 Oct  2 15:36 config
drwxr-xr-x 2 root root 4096 Nov 11 11:54 logs
drwxr-xr-x 5 root root 4096 Nov 11 11:54 webapp
```

* attachments -- where the server stores uploaded files
* config -- where the external config files reside
* webapp -- the extracted WAR file

## Installing WAR Package in Tomcat

Copy war file into Tomcat webapps directory (your location may vary -- this is an example):

```bash
$ cp ~/vireo-4.0.0-SNAPSHOT.war /usr/local/tomcat/webapps/vireo.war
```

or as root:

```bash
$ cp ~/vireo-4.0.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
```


## Running as a stand-alone Spring Boot application

```bash
java -jar target/vireo-4.0.0-SNAPSHOT.war
```

## Configuring

There is an external `application.properties` file under the `config` directory that you can modify to override the values in the built-in `application.properties`.

**NOTE: The `config` directory is only available if deployed from the ZIP package.**

**NOTE: If you need an external configuration file to the WAR file, you'll need to put a `config` directory in the same directory as the WAR file (whether running inside tomcat or as stand-alone Spring Boot application).**

**You should configure the following properties for production**

* spring.datasource.platform
* spring.datasource.url
* spring.datasource.driverClassName
* spring.jpa.database-platform
* spring.datasource.username
* spring.datasource.password
* spring.jpa.hibernate.ddl-auto

* app.url
* app.assets.uri

* app.authority.admins

* auth.security.jwt.secret
* auth.security.jwt.issuer
* auth.security.jwt.duration

* app.security.secret
* app.security.allow-access

* app.email.host
* app.email.from
* app.email.replyTo

* app.reporting.address
