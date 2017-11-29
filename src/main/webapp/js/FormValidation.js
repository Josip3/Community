
window.addEventListener("load",function(){
    document.getElementById("regBtn").addEventListener("click",function(){
        //get
        var inp1 = document.getElementById("pas1"),
            inp2 = document.getElementById("pas2"),
            userName = document.getElementById("userName"),
            lastName = document.getElementById("userLastName");
        //value
        var chec = document.getElementById("pas1").value,
            checName = document.getElementById("userName").value,
            checkLastName = document.getElementById("userLastName").value;

        if(checkLastName.indexOf(' ') > 0){
            alert("Поле з прізвищем не допускає пробіл")
            lastName.value = "";
            lastName.style.borderColor = "red";
        }

        if(checName.indexOf(' ') > 0){
            alert("Поле з іменем не допускає пробіл")
            userName.value = "";
            userName.style.borderColor = "red";
        }

        if (chec.length < 6){
            alert("Пароль надто короткий")
            inp1.value = "";
            inp2.value = "";
            inp1.style.borderColor = "red";
            inp2.style.borderColor = "red";
        }

        if(inp1.value!=inp2.value){
            alert("Пароли не совпадают")
            inp1.value = "";
            inp2.value = "";
        }
    });
})

function generateSome() {
    var html = document.getElementById("dupa");
    html.innerHTML = "<div style='background: red;width: 100px;height: 100px'></div>";
}

function generatePhotoSelect() {

    document.getElementById("dupa").innerHTML = " <div>\n" +
        "                <form:form action=\"saveImage\" method=\"post\" enctype=\"multipart/form-data\">\n" +
        "                    <input type=\"file\" path=\"image\" name=\"image\">\n" +
        "                    <button type=\"submit\">Do something crazy</button>\n" +
        "                </form:form>\n" +
        "            </div>"

}