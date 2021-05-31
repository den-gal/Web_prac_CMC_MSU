<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ru">
   <head>
      <title>Cars</title>
   </head>
   <body>
      <div>       <!-- header -->
         <hr>
         <h2>
            Cars according to your order:
         </h2>
         <hr>
      </div>
      <c:if test="${client.login != null}">
         <div>
            <h3>
                  ${client.full_name}
            </h3>
            <hr>
         </div>
      </c:if>
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
            <tr>
               <td>${car_inf.brand}</td>
               <td>${car_inf.manufacturer}</td>
               <td>${car_inf.technical_not}</td>
               <td>${car_inf.addition_devices}</td>
               <td>${car_inf.costumer_not}</td>
               <td>${car_inf.mutable_not}</td>
               <td>${car_inf.price}</td>
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
                     <c:if test="${client.login != null}">
                        <button type="button" onclick="location.href='/sign_in/checkout/${car.reg_id}/${client.client_id}'" id="checkout">Checkout</button>
                     </c:if>
                     <c:if test="${client.login == null}">
                        <button type="button" onclick="location.href='/confirm_form/checkout/${car.reg_id}'" id="checkout">Checkout</button>
                     </c:if>
                  </td>
               </tr>
            </c:forEach>
         </table>
      </div>
   </body>
</html>