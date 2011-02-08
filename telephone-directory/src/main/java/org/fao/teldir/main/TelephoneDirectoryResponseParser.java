package org.fao.teldir.main;

import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;

import org.fao.teldir.tags.ContactTag;
import org.fao.teldir.tags.NameDeptTag;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;

public class TelephoneDirectoryResponseParser {

	private static final boolean RECURSIVELY = true;
	private static final String EXTENSION = "extension";
	private static final String ROOM_NUMBER = "roomNumber";
	private static final String TITLE = "title";
	private static final String STAFF_MEMBER = "staffMember";
	private static final String CLASS = "class";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		String intranetSearch = "http://intranet.fao.org/IntranetServlet?"+"searchType=teldir&pg=teldir&search_string=gio";
		try {
		    
			URL url = new URL(intranetSearch);
	        URLConnection urlConnection = url.openConnection();
			
		    parse(urlConnection, System.out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void parse(URLConnection urlConnection, PrintStream printStream) throws Exception {
		Parser parser = new Parser(urlConnection);
		
		NodeList allNodes = parser.parse(null); 
		
		NodeList tables = allNodes.extractAllNodesThatMatch(new TagNameFilter(new TableTag().getTagName()), RECURSIVELY);
		
		NodeList staffMemberTables  = tables.extractAllNodesThatMatch(new HasAttributeFilter(CLASS, STAFF_MEMBER));
		
		NodeList tds  = staffMemberTables.extractAllNodesThatMatch(new TagNameFilter(new TableColumn().getTagName()), RECURSIVELY);
		
//		    Response response = new Response();

		NodeList nameDeptTDs = tds.extractAllNodesThatMatch(new HasAttributeFilter(CLASS, NameDeptTag.NAME));
		for(int i=0, n = nameDeptTDs.size(); i<n; i++) {
			String staffMemberName = nameDeptTDs.elementAt(i).getFirstChild().getFirstChild().toHtml();
			ContactTag contactTag = new ContactTag();
			contactTag.withNameDept(new NameDeptTag(staffMemberName.replace("\r\n", ""))).writeTo(printStream);
//				response.add(contactTag);
//				System.out.println(response);
		}
		
//		    response.writeTo(System.out);
		
//		    NodeList titleTDs = tds.extractAllNodesThatMatch(new HasAttributeFilter(CLASS, TITLE));
//		    NodeList roomNumberTDs = tds.extractAllNodesThatMatch(new HasAttributeFilter(CLASS, ROOM_NUMBER));
//		    NodeList extensionTDs = tds.extractAllNodesThatMatch(new HasAttributeFilter(CLASS, EXTENSION));
	}
}
