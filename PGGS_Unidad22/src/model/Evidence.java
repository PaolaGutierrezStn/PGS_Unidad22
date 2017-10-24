package model;

public class Evidence {
	private String id;
	private String code;
	private int associationId;
	private int dbxrefId;
	private String seqAcc;
	
	public Evidence(String id, String code, int associationId, int dbxrefId, String seqAcc) {
		super();
		this.id = id;
		this.code = code;
		this.associationId = associationId;
		this.dbxrefId = dbxrefId;
		this.seqAcc = seqAcc;
	}
	
	public Evidence() {
		this("", "", 0, 0, "");		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getAssociationId() {
		return associationId;
	}

	public void setAssociationId(int associationId) {
		this.associationId = associationId;
	}

	public int getDbxrefId() {
		return dbxrefId;
	}

	public void setDbxrefId(int dbxrefId) {
		this.dbxrefId = dbxrefId;
	}

	public String getSeqAcc() {
		return seqAcc;
	}

	public void setSeqAcc(String seqAcc) {
		this.seqAcc = seqAcc;
	}

	
	
	
	
	
}
