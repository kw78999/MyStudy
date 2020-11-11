package JAVAP;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* Name of the class has to be "Main" only if the class is public. */
public class ParseEx3{
	ParseEx3(){};
	String isbn = "", title = "", author = "",pub = "";
	List<String> isbn1 = new ArrayList<>();
	List<String> title1 = new ArrayList<>();
	List<String> author1 = new ArrayList<>();
	List<String> pub1 = new ArrayList<>();
	
	public ParseEx3(String test) {
	        try{
	            // XML 데이터를 읽어옴
	            URL url = new URL("https://www.nl.go.kr/NL/search/openApi/search.do?"
	            		+ "key=7523f3fb30bc248452fd33d9d66c72ab188d9394ba612470ca200a6cbaffceb3"
	            		+ "&detailSearch=true&isbnOp=isbn&isbnCode="
	            		+ test+"");
	            InputStream in = url.openStream();
	            
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder db = factory.newDocumentBuilder();
	            Document doc = db.parse(in);
	            
	            Element el = doc.getDocumentElement();
	            // <item> ~ </item>을 하나의 노드로 노드 리스트를 만듬
	            NodeList itemList = el.getElementsByTagName("item");
	            
	            for(int i = 0 ; i < itemList.getLength() ; i++){
	                // <item> ~ </item> 노드를 하나씩 읽어옴
	                Node itemNode = itemList.item(i);
	                // <item> ~ </item> 사이의 태그들로 노드 리스트를 만듬
	                NodeList subList = itemNode.getChildNodes();
	                
	                // <item> ~ </item> 사이의 태그를 하나씩 읽어와 해당 태그와 일치할 경우 변수에 저장
	                for(int j = 0 ; j < subList.getLength() ; j++){
	                    Node subNode = subList.item( j);
	                    if(subNode.getNodeName().equals("isbn"))
	                        isbn = subNode.getTextContent();
	                    if(subNode.getNodeName().equals("title_info"))
	                        title = subNode.getTextContent();
	                    if(subNode.getNodeName().equals("author_info"))
	                        author = subNode.getTextContent();
	                    if(subNode.getNodeName().equals("pub_info"))
	                        pub = subNode.getTextContent();
	                }

	               /* System.out.println("item #" + i);
	                System.out.println("isbn : " + isbn);
	                System.out.println("도서명 : " + title);
	                System.out.println("저자 : " + author);
	                System.out.println("출판사 : " + pub);
	                System.out.println("******************");*/
	                
	                isbn1.add(isbn);
	                title1.add(title);
	                author1.add(author);
	                pub1.add(pub);
	                
	                
	                isbn = "";
	                title = "";
	                author = "";
	                pub = "";
	                
	            }
	            
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	        
	        
	        
	}
public static void main(String[] args) {
	new ParseEx3();
}
    
}