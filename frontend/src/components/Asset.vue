<template>

<v-data-table
    :headers="headers"
    :items="asset"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'Asset',
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        headers: [
            { text: "item", value: "item" },
            { text: "amount", value: "amount" },
            { text: "accountId", value: "accountId" },
        ],
        asset : [],
    }),
    async created() {
      var temp = await axios.get(axios.backend + '/assets')

      this.asset = temp.data._embedded.assets;

    },
    methods: {
    }
  }
</script>

