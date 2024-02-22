function dopay(){

     let payreason = document.querySelector('#payreason').value; console.log(payreason);
     let pay = document.querySelector('#pay').value;  console.log(pay);

     let info = {
     payreason : payreason , pay : pay
    }

     $.ajax({
           url : `/members/pay/${mno}`,
           method : 'POST',
           data :   info ,
           success : function ( result ) {
            //4. 결과
           console.log(result);

           if(result){
            alert('급여 등록 성공'); dopaypage(); //페이 목록 새로고침 // 급여 목록 새로고침
           }else{alert('급여 등룍 실패');}
           }
     })
}



function dopaypage(mno){
 console.log('dopaypage() js실행');
 console.log(mno);

 location.href = 'http://localhost:80/TrioTeam/paypage.html'

$.ajax({
       url : `/members/pay/${mno}`,
       method : 'GET',
       success : function ( result ){

       console.log("result "+result);


    //1. 어디에
    let tbody = document.querySelector('table tbody');
    //2. 무엇을
    let html = "";

    for(let i = 0; i<result.length; i++){
     console.log( result[i] );
        html +=` <tr>
                        <th> ${result[i].mno} </th> <th> ${result[i].payreason}  </th> <th> ${result[i].pay}  </th>
                   </tr>`
     };

     //3.출력
     tbody.innerHTML = html;

     }
    })
}

