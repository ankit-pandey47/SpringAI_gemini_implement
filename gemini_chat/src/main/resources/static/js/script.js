function askquestion(event) {
  event.preventDefault(); // Prevent form submission from refreshing the page
  let ip = document.getElementById("input").value;
  console.log(ip); // Logs the input value to the console

  fetch(`http://localhost:8081/ask/${ip}`)
      .then(Response=> Response.json())
      .then(
        data => {
			let text = data.candidates[0].content.parts[0].text;
			console.log(text)
			
			text = text.replace(/\*\*/g, '');
			sessionStorage.setItem('question' , ip);
			sessionStorage.setItem('answer' , text);
			
			let output = document.getElementById("output")
			output.innerText = text;
			}
      )
}



window.onload = function() {
  let storedAnswer = sessionStorage.getItem('answer');
  let storedquestion = sessionStorage.getItem('question');
  if (storedAnswer) {
    document.getElementById("output").innerText = storedAnswer;
  }
  if(storedquestion){
	document.getElementById("input").value = storedquestion;
  }
};







