function processGetResponse(result) {
    // Can grab any DIV or SPAN HTML element and can then manipulate its
    // contents dynamically via javascript
    console.log("get project:" + result);
  
    refreshConstantsList();
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
            processCreateResponse(xhr.responseText);
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
  