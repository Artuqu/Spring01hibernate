<%--
  Created by IntelliJ IDEA.
  User: Art
  Date: 2020-10-11
  Time: 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student</title>
</head>
<body>

<form method="post">

    <div>
        <label for="firstName">FirstName</label>
        <input type="text" id="firstName" name="firstName">
    </div>
    <div>
        <label for="lastName">LastName</label>
        <input type="text" id="lastName" name="lastName">
    </div>
    <div>
        <label for="">Gender:</label>
        <label for="K">K</label>
        <input type="radio" id="K" name="gender">
        <label for="M">M</label>
        <input type="radio" id="M" name="gender">
    </div>
        <div>
            <label for="country">Country</label>

            <select id="country">
                <option value="p">Poland</option>
                <option value="uk">United Kingdom</option>
                <option value="us">United States</option>
            </select>
        </div>
<div>
    <label for="notes">Notes</label>
    <input type="text" id="notes" name="notes">
</div>

    <div>
        <label for="mailingList">MailingList</label>
<input type ="checkbox" id="mailingList" name="mailingList">


    </div>

    <div>
        <label for="programmingSkills">Programming Skills</label>

        <select id="programmingSkills" multiple="true">
            <option value="java">Java</option>
            <option value="phyton">Phyton</option>
            <option value="c#">C#</option>
        </select>
    </div>

        <div>
        <input type="submit">
        </div>


</form>


firstName (pole tekstowe)
- lastName (pole tekstowe)
- gender (radio button)
- country (select z możliwością pojedynczego wyboru)
- notes (textarea)
- mailingList (checkbox)
- programmingSkills (select z możliwością wyboru wielu opcji)
- hobbies (grupa checkboxów)

</body>
</html>
