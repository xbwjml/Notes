<template>
  <div>
    <my-add></my-add>
    <p>-----------</p>
    <my-minus></my-minus>
  </div>
</template>

<script>
import Additon from './components/addition.vue';
import Substration from './components/substra.vue';

export default {
  data(){
    return{};
  },

  components:{
    'my-add': Additon,
    'my-minus':Substration
  }
}
</script>
