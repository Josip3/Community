



function generatePhotoSelect() {

    document.getElementById("userContent").innerHTML = " <div>\n" +
        "<form:form action=\"saveImage\" method=\"post\" enctype=\"multipart/form-data\">\n" +
        "<input type=\"file\" path=\"image\" name=\"image\">\n" +
        "<button type=\"submit\">Do something crazy</button>\n" +
        "</form:form>\n" +
        "</div>"

}