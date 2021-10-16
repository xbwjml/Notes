<template>
    <div>
        <h3>当前count值为: {{count}}</h3>
        <h3>msg: {{msg}}</h3>
        <button @click="sub">-</button>
        <button @click="subbbbb">-n</button>
    </div>
</template>

<script>
import {mapState, mapMutations} from 'vuex';

export default{
    data(){
        return {}
    },

    computed: {
        ...mapState(['count','msg'])
    },

    methods: {
        ...mapMutations(['sub','subN']),
        subbbbb(){
            this.subN(3);
        }
    }
} 
</script>
