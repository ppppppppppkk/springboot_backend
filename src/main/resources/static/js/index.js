
//모든 페이지에서 적용할 공통 js
//1. 로그인 여부 확인 요청
$.ajax({
    url : '/member/login/check' ,
    method :  'get' ,
    success : (r)=>{
        console.log(r);
        //1. 어디에
        let login_memu = document.querySelector('#login_memu');
        //2. 무어슬
        let html = ``;

        if( r != 0){ //로그인 했을때
            html += `<li class="nav-item"> <a class="nav-link" onclick="logout()">로그아웃</a> </li>
                      <li class="nav-item"> <a class="nav-link" href="#">내정보</a></li>
                        <li class="nav-item"> <img src="#"/> 유재석님 </li> `;
        }else{ //로그인 안했을때
            html += ` <li class="nav-item"> <a class="nav-link" href="/member/login">로그인 </a> </li>
                <li class="nav-item"> <a class="nav-link" href="/member/signup">회원가입</a>  </li>`;
        }
        //3. 대입
        login_memu.innerHTML = html;


    }//s end
}); //ajax e

//2. 로그아웃
function logout(){
    $.ajax({
    url : '/member/logout' ,
    method : 'get' ,
    success : (r)=>{
    if(r){
        alert('로그아웃 완료');
        location.href='/';
    }else{
        alert('로그아웃 실패');
    }
    }
    });
}
