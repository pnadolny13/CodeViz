var myImage = document.querySelector('img');

myImage.onclick = function() {
    var mySrc = myImage.getAttribute('src');
    if(mySrc === 'images/ron.jpg') {
      myImage.setAttribute ('src','images/pat.jpg');
    } else {
      myImage.setAttribute ('src','images/ron.jpg');
    }
}