function processDeleteResponse(result){

    console.log("deleted: " + result); 

    refreshProjectsList();
}

function requestDelete(val){
    var form = document.deleteProject;

    var data = {}; 
    data["name"] = form.projectName.value; 
    console.log(form.projectName.value);

    val = form.projectName.value;

    if(confirm("Process to delete this project: " + val)){
        processDelete(val);
    }
}
function processDelete(name){
    var announ = document.getElementById('project-anno');
    var output ="";
    var xhr = new XMLHttpRequest();
    xhr.open("POST", delete_url + "/" + name, true); 

    xhr.onloadend = function(){
        console.log(xhr); 
        console.log(xhr.request); 

        if(xhr.readyState == XMLHttpRequest.DONE){
            if(xhr.status == 200){
                console.log("actual:" + xhr.responseText);
                processDeleteResponse(xhr.responseText);
                output = "Project Deleted!"
            }
            else{
                console.log("Actual:" + xhr.responseText); 
                var js = JSON.parse(xhr.responseText); 
                var err = js["error"];
                alert(err);
                output = "Something is wrong!"
            }
        }
        else{
            processDeleteResponse("N/A");
        }
    };
    xhr.send(null);
    announ.innerHTML = output;

}