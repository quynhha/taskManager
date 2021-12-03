function processDeleteResponse(result){

    console.log("deleted: " + result); 

    refreshProjectsList();
}

function requestDelete(val){
    if(confirm("Process to delete this project: " + val)){
        processDelete(val);
    }
}
function processDelete(name){
    var xhr = new XMLHttpRequest();
    xhr.open("POST", delete_url + "/" + name, true); 

    xhr.onloadend = function(){
        console.log(xhr); 
        console.log(xhr.request); 

        if(xhr.readyState == XMLHttpRequest.DONE){
            if(xhr.status == 200){
                console.log("actual:" + xhr.responseText);
                processDeleteResponse(xhr.responseText);
            }
            else{
                console.log("Actual:" + xhr.responseText); 
                var js = JSON.parse(xhr.responseText); 
                var err = js["error"];
                alert(err);
            }
        }
        else{
            processDeleteResponse("N/A");
        }
    };
    xhr.send(null);
}