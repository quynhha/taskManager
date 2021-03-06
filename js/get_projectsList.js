/**
 * Refresh project list from server
 *
 *    GET list_url
 *    RESPONSE  list of [name, id] projects 
 */
function refreshProjectsList() {
   var xhr = new XMLHttpRequest();
   xhr.open("GET", list_url, true);
   xhr.send();
   
   console.log("sent");

  // This will process results and update HTML as appropriate. 
  xhr.onloadend = function () {
    if (xhr.readyState == XMLHttpRequest.DONE) {
      console.log ("XHR:" + xhr.responseText);
      processListResponse(xhr.responseText);
    } else {
      processListResponse("N/A");
    }
  };
}

/**
 * Respond to server JSON object.
 *
 * Replace the contents of 'projList' with a <br>-separated list of name, id  pairs.
 */
function processListResponse(result) {
  console.log("res:" + result);
  // Can grab any DIV or SPAN HTML element and can then manipulate its contents dynamically via javascript
  var js = JSON.parse(result);
  var projList = document.getElementById('projectList');
  
  var output = "";
  for (var i = 0; i < js.list.length; i++) {
    var projectJson = js.list[i];
    console.log(projectJson);
    
    var pname = projectJson["name"];
    var pid = projectJson["id"];

   
    output = output + "<div id=\"const" + pname + "\"><b>" + pname + ": ID - </b>  " + pid +  " <br></div>";
    
  }


  // Update computation result
  projList.innerHTML = output;
}

