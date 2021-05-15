<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ru">
   <head>
      <title>Cars</title>
   </head>
   <body>
      <!-- header -->
      <div>
         <h2>
            Cars according to your order:
         </h2>
      </div>
      <div>       <!-- content -->
         <table>
            <tr>
               <th>brand</th>
               <th>manufacturer</th>
               <th>technical_not</th>
               <th>addition_devices</th>
               <th>costumer_not</th>
               <th>mutable_not</th>
               <th>price</th>
               <th>action</th>
            </tr>
            <c:forEach var="car" items="${carsList}">
               <tr>
                  <td>${car.brand}</td>
                  <td>${car.manufacturer}</td>
                  <td>${car.technical_not}</td>
                  <td>${car.addition_devices}</td>
                  <td>${car.costumer_not}</td>
                  <td>${car.mutable_not}</td>
                  <td>${car.price}</td>
                  <td>
                     <a href="/confirm_form/checkout/${car.reg_id}">checkout</a>
                  </td>
               </tr>
            </c:forEach>
         </table>
      </div>
   </body>
</html>