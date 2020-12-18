<%@ page  contentType="text/html; charset=EUC-KR"%>
<%!
		int one ;
		int two  = 1;
		public int plus(){
			int three = one + two;
			return three;
		}
%>
<%= plus()%>