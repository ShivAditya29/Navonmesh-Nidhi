
  // Import the functions you need from the SDKs you need
  import { initializeApp } from "https://www.gstatic.com/firebasejs/10.10.0/firebase-app.js";
  // TODO: Add SDKs for Firebase products that you want to use
  // https://firebase.google.com/docs/web/setup#available-libraries

  // Your web app's Firebase configuration
  const firebaseConfig = {
    apiKey: "AIzaSyAkxAmMAeclAezrWJqWiLJIZyp8JL3pak8",
    authDomain: "login-database-e560f.firebaseapp.com",
    projectId: "login-database-e560f",
    storageBucket: "login-database-e560f.appspot.com",
    messagingSenderId: "307993443467",
    appId: "1:307993443467:web:f21418e59d98781782a88e"
  };

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);