function boardlist() {

let name = document.querySelector('#name').value;   console.log(name);
let title = document.querySelector('#title').value;   console.log(title);
let content = document.querySelector('#content').value;   console.log(content);


let info = {
    name : name , title : title , content : content
}; console.log( info );

 $.ajax({
            url : '/Duo/boardlist',
            method : 'POST',
            data : info ,
            success : function ( result ){
            console.log(result);
             //4. 결과
            if(result){
            alert('게시판 만들기 성공');

            }else{
            alert('게시판 만들기 실패');
            }

            }
        })
}

function show(){
let info = {
    name : name , title : title , content : content
}; console.log( info );


 $.ajax({
            url : '/Duo/show',
            method : 'GET',
            data : 'info' ,
            success : function ( result ){
            console.log(result);
            }
            })
     let show = document.queryselector(show);
        let html = '';
     for( let i = 0; i<result.length; i++){
       html +=`
       <tr>
       <td>${result[i].name}</td>
       <td>${result[i].title}</td>
       <td>${result[i].content}</td>
       <td><button type="button" onclick=""> 삭제 </button> </td>
       </tr>`;
       }
        show.innerHTML = html;
     }


