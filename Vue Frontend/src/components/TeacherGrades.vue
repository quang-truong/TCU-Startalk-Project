<template>
<div class="py-10">
    <header style="padding-bottom: 2.5em;">
        <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
          <h1 class="text-3xl font-bold leading-tight text-gray-900">
            Edit Grades
          </h1>
        </div>
    </header>
    <main>
        <div class="max-w-7xl mx-auto sm:px-6 lg:px-8">
          <!-- Replace with your content -->
          <div class="flex flex-col">
    <div class="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
      <div class="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
        <div class="shadow overflow-hidden border-b border-gray-200 sm:rounded-lg">
          <table class="min-w-full divide-y divide-gray-200">
            <thead class="bg-gray-50">
              <tr>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                  Name
                </th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                  Submission
                </th>
                <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                  Score
                </th>
              </tr>
            </thead>
            <tbody class="bg-white divide-y divide-gray-200">
              <tr v-for="student in students" :key="student.email">
                <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900 text-left">
                  {{ student.name }}
                </td>
                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500 text-left">
                  {{ student.submission }}
                </td>
                <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500 text-left">
                  {{ student.score }}
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
          </div>
          <!-- /End replace -->
        </div>
           </main>
</div>
</template>

<style scoped>

</style>

<script>

const students = [{
    name: 'Jane Cooper',
    email: 'you@example.com',
    score: 100,
    submission: 'File name'
}]
export default {
    setup() {

    },
    data: function(){
        return{
            students
        }
    }
}
</script>