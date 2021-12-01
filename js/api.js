// all access driven through BASE. Must end with a SLASH
// be sure you change to accommodate your specific API Gateway entry point
var base_url = "https://t6c1f7j814.execute-api.us-east-2.amazonaws.com/beta/";

var list_url   = base_url + "projects";    // GET
var create_url = base_url + "projects";    // POST

var get_url = base_url + "projects"; //GET with {projectname}
