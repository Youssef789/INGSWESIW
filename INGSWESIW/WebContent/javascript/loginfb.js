  window.fbAsyncInit = function() {
    FB.init({
      appId      : '157070194928528',
      cookie     : true,
      xfbml      : true,
      version    : 'v2.11'
    });
      
    
    FB.getLoginStatus(function(response) {
        statusChangeCallback(response);
    });
      
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "https://connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
    
    function statusChangeCallback(response){
        if(response.status === 'connected'){
            console.log('logged in and authenticated');
            setElements(true);
            testAPI();
        }
        else{
            console.log('not authenticated');
            setElements(false);
        }
    }
    
    function testAPI(){
        FB.api('me/?fields=name,email,birthday,picture.width(150).height(150)',function(response){
            if(response&&!response.error){
                buildProfile(response);
            }
        })
    }

    function buildProfile(user){
        let profile=`
        <img src="${user.picture.data.url}">
        <h3>${user.name}</h3>
        <ul class="list-group">
            <li class="list-group-item">Email : ${user.email}</li>
            <li class="list-group-item">Birthday : ${user.birthday}</li>
           
        </ul>
        `;
        document.getElementById('profile').innerHTML=profile;
    }

    function setElements(isLoggedIn){
        if(isLoggedIn){
            document.getElementById('logout').style.display='black';
            document.getElementById('profile').style.display='black';
            document.getElementById('signup').style.display='none';
            document.getElementById('signin').style.display='none';
            document.getElementById('fb-btn').style.display='none';
            document.getElementById('heading').style.display='none';
        }
        else{
            document.getElementById('logout').style.display='none';
            document.getElementById('profile').style.display='none';
            document.getElementById('fb-btn').style.display='black';
            document.getElementById('heading').style.display='black';
            document.getElementById('signup').style.display='black';
            document.getElementById('signin').style.display='black';
        }
    }

    function logout(){
        FB.logout(function(response){
                  setElements(false);
        });
    }

    function checkLoginState() {
      FB.getLoginStatus(function(response) {
        statusChangeCallback(response);
      });
    }