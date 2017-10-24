package dom;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.Evidence;

public class EvidenceDOM {
	private String pathFile = "E:\\4C-GSI1342\\Aplicaciones 2 - Tacho\\workspace\\PGGS_Unidad22\\src\\data\\evidences.xml";								
	public void add(Evidence data) {
		try {
			
				Document document = DOMHelper.getDocument(pathFile);
				Element evidences = document.getDocumentElement();
				
				//CREATE  TAG
				
				Element evidence = document.createElement("evidence");
				
				//CREAR ID TAGG
				
				Element id = document.createElement("id");
				id.appendChild(document.createTextNode(data.getId()));
				evidence.appendChild(id);
				
				// create code tag
				
				Element code = document.createElement("code");
				code.appendChild(document.createTextNode(data.getCode()));
				evidence.appendChild(code);
				
					// create associationid tag
				
				Element associationId = document.createElement("associationId");
				associationId.appendChild(document.createTextNode(String.valueOf(data.getAssociationId())));
				evidence.appendChild(associationId);
				
				//create dbxrefid tag
				
				Element dbxrefId = document.createElement("dbxrefId");
				dbxrefId.appendChild(document.createTextNode(String.valueOf(data.getDbxrefId())));
				evidence.appendChild(dbxrefId);
				
				//create seqacc 
				
				Element seqAcc = document.createElement("seqAcc");
				seqAcc.appendChild(document.createTextNode(data.getSeqAcc()));
				evidence.appendChild(seqAcc);
				
				evidences.appendChild(evidence);
				
				// Write to file
				DOMHelper.saveXMLContent(document, pathFile);
		}catch(Exception e){
			
				System.out.println(e.getMessage());
			
		}
	}
	
	public void delete (String id ) {
		
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("evidence");
			for (int i =0; i< nodelist.getLength(); i++) {
				
				Element evidence = (Element)nodelist.item(i);
				if (evidence.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					evidence.getParentNode().removeChild(evidence);
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update (Evidence data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("evidence");
			for (int i =0; i< nodelist.getLength(); i++) {
				Element evidence = (Element)nodelist.item(i);
				if (evidence.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
					evidence.getElementsByTagName("code").item(0).setTextContent(data.getCode());					
					evidence.getElementsByTagName("associationId").item(0).setTextContent(String.valueOf(data.getAssociationId()));
					evidence.getElementsByTagName("dbxrefId").item(0).setTextContent(String.valueOf(data.getDbxrefId()));
					evidence.getElementsByTagName("seqAcc").item(0).setTextContent(data.getSeqAcc());
					
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Evidence findById(String id) {
		Evidence evidence = null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("evidence");
			for(int i=0; i<nodelist.getLength(); i++) {
				Element s = (Element)nodelist.item(i);
				if(s.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					evidence = new Evidence();
					evidence.setId(id);
					evidence.setCode(s.getElementsByTagName("code").item(0).getTextContent());					
					evidence.setAssociationId(Integer.parseInt(s.getElementsByTagName("associationId").item(0).getTextContent()));
					evidence.setDbxrefId(Integer.parseInt(s.getElementsByTagName("dbxrefId").item(0).getTextContent()));
					evidence.setSeqAcc(s.getElementsByTagName("seqAcc").item(0).getTextContent());
				}
				
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return evidence;
	}
	
	public  List<Evidence> getEvidences(){
		
		List<Evidence> evidences = new ArrayList<Evidence>();
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodelist = document.getElementsByTagName("evidence");
		for (int i =0; i<nodelist.getLength(); i++) {
			
			Element s = (Element)nodelist.item(i);
			Evidence evidence = new Evidence();
			evidence.setId(s.getElementsByTagName("id").item(0).getTextContent());
			evidence.setCode(s.getElementsByTagName("code").item(0).getTextContent());
			evidence.setAssociationId(Integer.parseInt(s.getElementsByTagName("associationId").item(0).getTextContent()));
			evidence.setDbxrefId(Integer.parseInt(s.getElementsByTagName("dbxrefId").item(0).getTextContent()));
			evidence.setSeqAcc(s.getElementsByTagName("seqAcc").item(0).getTextContent());
			
			evidences.add(evidence);
			
		}
		return evidences;
	}
}

