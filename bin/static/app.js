var footerText = document.querySelector('footer');
footerText.addEventListener('click', function() {
  if (this.innerText !== "Boom Baby!") {
    this.innerText = "Boom Baby!";
  } else {
    this.innerText = "Copyright 2017";
  }
});



var removeTagButton = document.getElementById('removeTagButton');
  removeTagButton.onclick = function() {
    if(!confirm("You sure?")){
      removeTagButton.setAttribute('th:formaction', '@{/remove-tag-cancelled(id=${review.id})}');
    }
  };

  var headerGrow = document.querySelector('header');
  	headerGrow.addEventListener('mouseover',function(){
  		this.style.fontSize = '50px';
  			});
  	headerGrow.addEventListener('mouseout',function(){
  	this.style.fontSize = '100%';
  	});
