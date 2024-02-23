console.log('js실행')
/*

    1. 함수 :function 함수명() {}
    2. 익명 : function 함수명(){}

*/

let id = 9;
let content = "AJAX테스트중";



function ajax1(){ console.log('ajax1()');
    $.ajax({
        url : "/day11/ajax1",
        method : "get",
        success : ( result ) => { console.log(result); } ,
        error : ( error ) => { console.log( error ); }
    });
}
//-------------------------------------------------------------
function ajax2(){
    $.ajax({
    url : `/day11/ajax2/${id}/${content}`,
    method: "get",
    success : ( r ) => {console.log(r);}
    });
}
//--------------------------------------------------------

function ajax3(){
    $.ajax({
    url : `/day11/ajax3?id=${id}&content=${content}`,
    method: "get",
    success : (r) => {console.log(r); }
    });
}
//------------------------------------------------------
//4. HTTP 본분(body) 에 객체 보내기
function ajax4(){
    $.ajax({
    url : 'day11/ajax4',
    method : "get",
    data :  { 'id' : id , 'content' : content},
    success : (r) => {console.log(r);}
    });
}
//-----------------------------------------------------
function ajax5(){
    $.ajax({
    url : 'day11/ajax5',
    method : "post",
    data :  { 'id' : id , 'content' : content},
    success : (r) => {console.log(r);}
    });
}
//-----------------------------------------------------
function ajax6(){
    $.ajax({
    url : "day11/ajax6",
    method : 'post',
    data :  JSON.stringify( { 'id' : id , 'content' : content} ),
    contentType : 'application/json',
    success : (r) => {console.log(r);}
    });
}