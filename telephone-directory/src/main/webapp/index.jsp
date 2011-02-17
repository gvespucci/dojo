<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta name="generator" content="HTML Tidy for Linux/x86 (vers 11 February 2007), see www.w3.org" />
  <style type="text/css">
/*<![CDATA[*/
  /* ------ TELSEARCH ------ */
  td.telsearch input {
  font-family: Arial, Helvetica, sans-serif;
  font-size: 13px;
  color: #003366;
  border-color: #999999;
  border-width: 1px;
  }

  td.telsearch {
  background-color: #eeeeee;
  }

  td.telSearchHeading  {
  font-family: Verdana,Arial, Helvetica, sans-serif;
  font-size: 11px;
  font-weight: bold;
  color: white;
  background-color: #666666;
  }
  /*]]>*/
  </style>

  <title></title>
  <style type="text/css">
/*<![CDATA[*/
  span.c3 {font-family: Verdana,Arial,Helvetic,sans-serif}
  span.c2 {font-size: 70%}
  span.c1 {font-family: Verdana,Arial,Helvetic,sans-serif; font-size: 70%}
  /*]]>*/
  </style>
</head>

<body >
	<center>
  <form name="frmAdvTelFind" action="./teldir" method="post" id="frmAdvTelFind">
  	<input type="hidden" name="searchType" value="teldir" />
  	<input type="hidden" name="pg" value="teldir" />
  	
	<%@page import="org.fao.teldir.marshall.Marshaller" %>
  	<input type="hidden" name="format" value="<%=Marshaller.XML%>" />
	
	  <table cellpadding="6" cellspacing="0" width="165">
	    <tr>
	      <td class="telSearchHeading">Directory Search</td>
	    </tr>
	
	    <tr>
	      <td class="telsearch">
	        <table cellpadding="3" cellspacing="0">
	          <tr>
	            <td>
	              <span class="c1">Last Name<br /></span> <input name="last" size="18" value="" /><br />
	              <span class="c1">First Name<br /></span> <input name="first" size="18"value="" /><br />
	
	              <table border="0" cellspacing="0" cellpadding="0" width="100%">
	                <tr>
	                  <td><span class="c1">Division<br /></span> <input maxlength="6" name="div" size="4" value="" />&nbsp;</td>
	
	                  <td><span class="c1">Room<br /></span> <input maxlength="4" name="rm" size="4" value="" />&nbsp;</td>
	                </tr>
	              </table>
	              <span class="c3"><span class="c2">Extension<br /></span></span>
	              <input maxlength="5" name="ext" size="5" value="" /><br />
	              <span class="c1">Title<br /></span> <input name="ttl" size="18" value="" />&nbsp;
	            </td>
	          </tr>
	          <tr>
	            <td align="center"><input type="submit" value="Find" name="findbtn" /></td>
	          </tr>
	        </table>
	      </td>
	    </tr>
	  </table><br />
</form>
</center>
</body>
</html>
