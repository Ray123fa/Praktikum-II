nim = document.getElementById("nim");
nama = document.getElementById("nama");
jurusan = document.getElementById("jurusan");

nim.addEventListener("keyup", function () {
  if (nim.value.length > 9) {
    alert("NIM tidak boleh lebih dari 9 karakter");
    nim.value = nim.value.substring(0, 9);
  }
});

nama.addEventListener("keyup", function () {
  if (!/^[a-zA-Z .]*$/.test(nama.value)) {
    alert("Nama hanya boleh mengandung huruf, titik, dan spasi");
    nama.value = nama.value.substring(0, nama.value.length - 1);
  }
});

jurusan.addEventListener("keyup", function () {
  if (!/^[a-zA-Z ]*$/.test(jurusan.value)) {
    alert("Jurusan hanya boleh mengandung huruf dan spasi");
    jurusan.value = jurusan.value.substring(0, jurusan.value.length - 1);
  }
});
