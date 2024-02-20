console.log('day08Board');

//1. 저장 메소드 : 실행조건 : 등록 버튼 클릭시
function doCreate(){
    console.log("doCreate()");

}
doRead(); //JS 열릴때 최초 실행
//2. 전체 호출 메소드 : 실행조건 : 페이지 열릴시
function doRead(){
 console.log("doRead()");
}
//3. 수정 메소드 : 실행조건 : 수행 버튼 클릭시
function doUpdate(bno){
 console.log("doUpdate()");
}
//4. 삭제 메소드 : 실행조건 : 삭제 버튼 클릭시
function doDelete(bno){
console.log("doDelete()");
}