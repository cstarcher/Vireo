package org.tdl.vireo.search;

/**
 * List of all possible ordering of Vireo submissions.
 * 
 * @author <a href="http://www.scottphillips.com">Scott Phillips</a>
 */
public enum SearchOrder {
	
	ID(1),
	STUDENT_EMAIL(2),
	STUDENT_NAME(3),
	STUDENT_ID(4),
	
	STATE(5),
	
	ASSIGNEE(6),
	
	DOCUMENT_TITLE(7),
	DOCUMENT_ABSTRACT(8),
	DOCUMENT_KEYWORDS(9),
	DOCUMENT_SUBJECTS(10),
	DOCUMENT_LANGUAGE(11),
	
	PRIMARY_DOCUMENT(12),
	
	GRADUATION_DATE(13),
	DEFENSE_DATE(14),
	SUBMISSION_DATE(15),
	LICENSE_AGREEMENT_DATE(16),
	APPROVAL_DATE(17),
	
	
	COMMITTEE_APPROVAL_DATE(18),
	COMMITTEE_EMBARGO_APPROVAL_DATE(19),
	COMMITTEE_MEMBERS(20),
	COMMITTEE_CONTACT_EMAIL(21),
	
	DEGREE(22),
	DEGREE_LEVEL(23),
	
	PROGRAM(24),
	COLLEGE(25),
	DEPARTMENT(26),
	MAJOR(27),
	
	EMBARGO_TYPE(28),
	DOCUMENT_TYPE(29),
	
	UMI_RELEASE(30),
	
	CUSTOM_ACTIONS(31),
	
	DEPOSIT_ID(32),
	
	LAST_EVENT_ENTRY(33),
	LAST_EVENT_TIME(34);
	
	// The id for this search order.
	private int id;

	/**
	 * Private constructor for the defined search orders listed above.
	 * 
	 * @param id
	 *            The id of the search order.
	 */
	private SearchOrder(int id) {
		this.id = id;
	}

	/**
	 * @return The code of this search order.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Locate a search order based upon it's id.
	 * 
	 * @param id
	 *            The of the search order.
	 * @return The search order, or null if not found.
	 */
	public static SearchOrder find(int id) {

		for (SearchOrder searchOrder : SearchOrder.values()) {
			if (searchOrder.id == id)
				return searchOrder;
		}

		return null;
	}
}
