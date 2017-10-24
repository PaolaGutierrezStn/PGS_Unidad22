package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dom.EvidenceDOM;
import model.Evidence;



/**
 * Servlet implementation class EvidenceController
 */

 @WebServlet("/EvidenceController")
public class EvidenceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Evidence evidence;
	private List<Evidence> evidences;
	private EvidenceDOM evidenceDOM;
	private List<String> ids = new ArrayList<String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EvidenceController() {
        super();
        evidence = new Evidence();
        evidences = new ArrayList<Evidence>();
        evidenceDOM = new EvidenceDOM();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if (request.getParameter("btn_save")!= null) {
    				
    				evidence.setCode(request.getParameter("code"));
    				evidence.setSeqAcc(request.getParameter("seqAcc"));
    				
    				try {
    					
    					evidence.setAssociationId(Integer.parseInt(request.getParameter("associationId")));
    				}catch(NumberFormatException e) {
    					evidence.setAssociationId(25);
    					
    					
    				}
    				
    	            try {
    					
    					evidence.setDbxrefId(Integer.parseInt(request.getParameter("dbxrefId")));
    				}catch(NumberFormatException e) {
    					evidence.setDbxrefId(20);
    					
    					
    				}
    				
    				if(evidence.getId()=="") {
    					int id = 1;
    					String newId= "evi"+String.format("%05d", 1);
    					evidence.setId(newId);;
    					
    					if (evidences.size()>0) {
    						ids.clear();
    						for (Evidence p: evidences) {
    							ids.add(p.getId());
    						}
    						for (int i=0; i<= ids.size(); i++){
    							newId= "evi"+ String.format("%05d", i+1);
    							
    							if (! ids.contains(newId)) {
    							evidence.setId(newId);
    							break;
    							}
    						}
    					}
    					evidenceDOM.add(evidence);
    				}else {
    					evidenceDOM.update(evidence);
    				}
    				evidences = evidenceDOM.getEvidences();
    				request.setAttribute("evidences", evidences);
    				request.getRequestDispatcher("evidence_list.jsp").forward(request, response);
    				
    			}else if (request.getParameter("btn_new")!=null) {
    				evidence = new Evidence();
    				request.getRequestDispatcher("evidence_form.jsp").forward(request, response);
    			
    			}else if(request.getParameter("btn_edit")!=null) {	
    				try {
    					String id = request.getParameter("id");
    					evidence = evidenceDOM.findById(id);
    					
    				}catch (Exception e) {
    					
    					evidence = new Evidence();
    				}
    				request.setAttribute("evidence", evidence );
    				
    				request.getRequestDispatcher("evidence_form.jsp").forward(request, response);
    				
    			}else if(request.getParameter("btn_delete")!=null) {
    			
    				
    				try {
    				String id = request.getParameter("id");
    				evidenceDOM.delete(id);
    				evidences = evidenceDOM.getEvidences();
    				
    				}catch(Exception e) {
    					e.printStackTrace();
    					
    					
    				}
    				request.setAttribute("evidences", evidences);
    				request.getRequestDispatcher("evidence_list.jsp").forward(request, response);
    			}else {
    				evidences = evidenceDOM.getEvidences();
    				request.setAttribute("evidences", evidences);
    				request.getRequestDispatcher("evidence_list.jsp").forward(request, response);
    			}
    		}

    		/**
    		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    		 */
    		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    			// TODO Auto-generated method stub
    			doGet(request, response);
    		}

    	}