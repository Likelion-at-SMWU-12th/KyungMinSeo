const input_name = prompt("이름을 입력해주세요!");

if (input_name != null) {
  document.getElementById("name").innerHTML = input_name;
}

const mainbox = document.getElementById("mainbox");

function darkmode() {
  mainbox.style.backgroundColor = "#262626";
  mainbox.style.color = "white";
}

function lightmode() {
  mainbox.style.backgroundColor = "white";
  mainbox.style.color = "black";
  h2.style.backgroundColor = "cornsilk";
}
