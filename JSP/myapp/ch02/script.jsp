
<%@ page  contentType="text/html; charset=EUC-KR"%>
<!-- ����(Declaration) -->
<%! 
			String dec = "���� ����"	;  //�ʵ�
			//�޼ҵ� ����
			public String decMethod(){  
					return dec;
			}
%>
<!--  ��ũ��Ʈ�� (scriptlet) -->
<%
			String scriptlet = "��ũ��Ʈ��";

			out.println("���尴ü�� �̿��� ��� : "+dec+"<p>");

%>
<!-- ǥ���� -->
������ ���1 : <%= dec %><p>
������ ���2 : <%= decMethod() %><p>
��ũ��Ʈ���� ��� 1: <%=scriptlet%>