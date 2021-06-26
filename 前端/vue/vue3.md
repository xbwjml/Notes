# 1.Vue初步体验

```html
<script src="../0source/vue.js" ></script>
    
    <div id='app' >{{msg}}</div>
    <div>{{msg}}</div>

    <script>
        const app = new Vue({
            el: '#app', 
            data:{
                msg:'HelloWorld!!!'
            }
        });
    </script>
```

