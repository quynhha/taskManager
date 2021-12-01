function processGetResponse(result) {
    // Can grab any DIV or SPAN HTML element and can then manipulate its
    // contents dynamically via javascript
    console.log("get project:" + result);
  
    refreshConstantsList();

    var display = document.getElementById('getProjDisplay');

    var js = JSON.parse(result);
  
    var output = "";
    for (var i = 0; i < js.list.length; i++) {
    var projectJson = js.list[i];
    console.log(projectJson);
    
    var pname = projectJson["name"];
    var pid = projectJson["id"];

   
    output = output + "<div id=\"const" + pname + "\"><b>" + pname + ": ID - </b>  " + pid +  " <br></div>";

    display.innerHTML = output;
  }
}

  function requestGet(val){
    if(confirm("Request to get this project:" + val)){
        processGet(val);
    }
  }
  
  function processGet(name) {
    var form = document.getProject;
   
    var data = {};
    data["name"] = form.projectName.value;
    console.log(form.projectName.value);
  
    var js = JSON.stringify(data);
    console.log("JS:" + js);
    var xhr = new XMLHttpRequest();
    xhr.open("GET", get_url + "/" + name, true);
  
    
  
    // This will process results and update HTML as appropriate. 
    xhr.onloadend = function () {
      console.log(xhr);
      console.log(xhr.request);
      if (xhr.readyState == XMLHttpRequest.DONE) {
           if (xhr.status == 200) {
            console.log ("XHR:" + xhr.responseText);
            processGetResponse(xhr.responseText);
           } else {
               console.log("actual:" + xhr.responseText)
                var js = JSON.parse(xhr.responseText);
                var err = js["response"];
                alert (err);
           }
      } else {
        processGetResponse("N/A");
      }
    };
    
  // send the collected data as JSON
    xhr.send(null);
  }
  