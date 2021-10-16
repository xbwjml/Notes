<template>
    <div>
        <!-- <h3>当前count值为:{{this.$store.state.count}}</h3> -->
        <h3>{{this.$store.getters.showNum}}</h3>
        <button @click="clickBtn">+</button>
        <button @click="clickBtnAsync">+async</button>
        <button @click="clickBtn2">+n</button>
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
            },
            clickBtn2(){
                this.$store.commit('addN', 10);
            },
            clickBtnAsync(){
                this.$store.dispatch('addAsyncc');
            }
        }
    }
</script>
