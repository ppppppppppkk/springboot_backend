console.log('day08Board');

//1. 저장 메소드 : 실행조건 : 등록 버튼 클릭시
function doCreate(){

    //1.입력받은 데이터 가져오기
    let bcontent = document.querySelector('#bcontent').value; console.log(bcontent);
    let bwriter = document.querySelector('#bwriter').value;  console.log(bwriter);
    let bpassword = document.querySelector('#bpassword').value;  console.log(bpassword);
    //*. 유효성 검사
    //2. 객체화
    let info = {
    bcontent : bcontent , bwriter : bwriter, bpassword : bpassword
    }; console.log(info);
    //3. controller 전송후 응답
    //------AJAX-----------------
    $.ajax({
       url : '/board/create',
       method : 'POST',
       data :   info ,
       success : function ( result ) {
        //4. 결과
       console.log(result);
       if(result){
        alert('글쓰기 성공'); doRead(); //안내후 게시물목록 새로고침
       }else{alert('글쓰기 실패'); }
       }
    })
    //-----------------------

}
doRead(); //JS 열릴때 최초 실행
//2. 전체 호출 메소드 : 실행조건 : 페이지 열릴시
function doRead(){
     //------AJAX-----------------
   $.ajax({
       url : '/board/read',
       method : 'GET',
       success : function ( result ){console.log(result);

    //1. 어디에
    let tbody = document.querySelector('table tbody');
    //2. 무엇을
    let html = "";

    for(let i = 0; i<result.length; i++){
     console.log( result[i] );
        html +=` <tr>
                        <th> ${result[i].bno} </th> <th> ${result[i].bcontent}  </th> <th> ${result[i].bwriter}  </th>
                        <th>
                        <button onclick="doDelete( ${ result[i].bno }  )" >삭제</button>
                        <button onclick="doUpdate( ${ result[i].bno }  )" >수정</button>
                        </th>
                    </tr>`
     };

    //3. 출력
    tbody.innerHTML = html;
    }
   })

}

//3. 수정 메소드 : 실행조건 : 수행 버튼 클릭시
function doUpdate(bno){
 console.log("doUpdate()");
 //1. 수정할 내용 가져온다.
 let bcontent = prompt('수정할 내용 :');
 let bpassword = prompt('게시물 비밀번호');

 let info = {
 bno : bno, bcontent : bcontent, bpassword : bpassword
 }

     //------AJAX-----------------
   $.ajax({
       url : '/board/update',
       method : 'POST',
       data :   info ,
       success : function ( result ){

       if(result){alert('글수정 성공'); doRead(); }
       else{ alert('글수정 실패');}

       }
    })


     //-----------------------
}

//4. 삭제 메소드 : 실행조건 : 삭제 버튼 클릭시
function doDelete(bno){
console.log("doDelete()");


 let bpassword = prompt('게시물 비밀번호');



    //------AJAX-----------------
   $.ajax({
       url : `/board/delete/${bno}/${bpassword}`,
       method : 'GET',

       success : function ( result ){

       if(result){alert('삭제 성공'); doRead(); }
       else{alert('삭제 실패');}

       }
    })


    //-----------------------
}