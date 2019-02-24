<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý quảng cáo</title>
        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />
    </head>
    <body>       
        <%
            String error = "";
            if(request.getParameter("error")!=null){
                error = (String) request.getParameter("error");
            }
        %>
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
            <jsp:include page="menu.jsp"></jsp:include>
                <div id="rightContent">
                    <h3>Thêm Quảng cáo</h3>
                    <form action="${root}/ManagerAdvertisementServlet" method="post">
                    <table width="95%">
                        <tr>
                            <td style="float: right"><b>Tên quảng cáo : </b></td>
                            <td><input type="text" class="sedang" name="tenQuangCao"><%=error%></td>
                        </tr>
                        <tr>
                            <td style="float: right"><b>Ảnh quảng cáo : </b></td>
                            <td><input type="file" class="sedang" name="img"></td>
                        </tr>
                        <tr>
                            <td style="float: right"><b>Tên đường dẫn: </b></td>
                            <td><input type="text" class="sedang" name="DuongDan"></td>
                        </tr>
                        <tr>
                            <td style="float: right"><b>Tên công ty : </b></td>
                            <td><input type="text" class="sedang" name="CongTy"></td>
                        </tr>
                        <tr><td></td><td>
                                <input type="hidden" name="command" value="insert">
                                <input type="submit" class="button" value="Lưu dữ liệu">
                            </td>
                        </tr>
                    </table>
                    </form>
                </div>
                <div class="clear"></div>
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>