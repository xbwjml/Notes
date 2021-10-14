<template>
    <div>
        <h3>当前count值为:{{this.$store.state.count}}</h3>
        <button @click="clickBtn">+</button>
    </div>
</template>

<script>
    export default{
        data(){
            return {}
        },

        methods:{
            clickBtn(){
                this.$store.commit('addd');
            }
        }
    }
</script>
