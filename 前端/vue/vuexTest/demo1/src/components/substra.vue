<template>
    <div>
        <h3>当前count值为: {{count}}</h3>
        <h3>msg: {{msg}}</h3>
        <button>-</button>
    </div>
</template>

<script>
import {mapState} from 'vuex';

export default{
    data(){
        return {}
    },

    computed: {
        ...mapState(['count','msg'])
    }
}
</script>
