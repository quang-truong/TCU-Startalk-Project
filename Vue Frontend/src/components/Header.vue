<!-- This example requires Tailwind CSS v2.0+ -->
<template>
  <Popover class="relative bg-white">
    <div class="max-w-7xl mx-auto px-4 sm:px-6">
      <div class="flex justify-between items-center border-b-2 border-gray-100 py-6 md:justify-start md:space-x-10">
        <div class="flex justify-start lg:w-0 lg:flex-1">
          <a href="#">
            <span class="sr-only">Workflow</span>
            <img v-on:click="toggleTextbook" class="h-8 w-auto sm:h-10" src="../assets/startalk.png" alt="" />
          </a>
        </div>
        <div class="-mr-2 -my-2 md:hidden">
          <PopoverButton class="bg-white rounded-md p-2 inline-flex items-center justify-center text-gray-400 hover:text-gray-500 hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-indigo-500">
            <span class="sr-only">Open menu</span>
            <MenuIcon class="h-6 w-6" aria-hidden="true" />
          </PopoverButton>
        </div>
        <PopoverGroup as="nav" class="hidden md:flex space-x-10">
          <Popover class="relative" v-slot="{ open }">
            <PopoverButton :class="[open ? 'text-gray-900' : 'text-gray-500', 'group bg-white rounded-md inline-flex items-center text-base font-medium hover:text-gray-900 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500']" style="display: none;">
              <span>Solutions</span>
              <ChevronDownIcon :class="[open ? 'text-gray-600' : 'text-gray-400', 'ml-2 h-5 w-5 group-hover:text-gray-500']" aria-hidden="true" />
            </PopoverButton>

            <transition enter-active-class="transition ease-out duration-200" enter-from-class="opacity-0 translate-y-1" enter-to-class="opacity-100 translate-y-0" leave-active-class="transition ease-in duration-150" leave-from-class="opacity-100 translate-y-0" leave-to-class="opacity-0 translate-y-1">
              <PopoverPanel class="absolute z-10 -ml-4 mt-3 transform px-2 w-screen max-w-md sm:px-0 lg:ml-0 lg:left-1/2 lg:-translate-x-1/2">
                <div class="rounded-lg shadow-lg ring-1 ring-black ring-opacity-5 overflow-hidden">
                  <div class="relative grid gap-6 bg-white px-5 py-6 sm:gap-8 sm:p-8">
                    <a v-for="item in solutions" :key="item.name" :href="item.href" class="-m-3 p-3 flex items-start rounded-lg hover:bg-gray-50">
                      <component :is="item.icon" class="flex-shrink-0 h-6 w-6 text-indigo-600" aria-hidden="true" />
                      <div class="ml-4">
                        <p class="text-base font-medium text-gray-900">
                          {{ item.name }}
                        </p>
                        <p class="mt-1 text-sm text-gray-500">
                          {{ item.description }}
                        </p>
                      </div>
                    </a>
                  </div>
                  <div class="px-5 py-5 bg-gray-50 space-y-6 sm:flex sm:space-y-0 sm:space-x-10 sm:px-8">
                    <div v-for="item in callsToAction" :key="item.name" class="flow-root">
                      <a :href="item.href" class="-m-3 p-3 flex items-center rounded-md text-base font-medium text-gray-900 hover:bg-gray-100">
                        <component :is="item.icon" class="flex-shrink-0 h-6 w-6 text-gray-400" aria-hidden="true" />
                        <span class="ml-3">{{ item.name }}</span>
                      </a>
                    </div>
                  </div>
                </div>
              </PopoverPanel>
            </transition>
          </Popover>

          <div v-on:click="toggleTextbook" class="section text-base font-medium text-gray-500 hover:text-gray-900">
            Courses
          </div>
          <!-- <div v-on:click="toggleAssignment" class=" section text-base font-medium text-gray-500 hover:text-gray-900">
            Assignment
          </div> -->
          <!-- <div v-on:click="toggleExam" class=" section text-base font-medium text-gray-500 hover:text-gray-900">
            Exam
          </div> -->
          <div v-on:click="toggleForum" class="section text-base font-medium text-gray-500 hover:text-gray-900">
            Forum
          </div>
          <!-- <div v-on:click="toggleHelp" class="section text-base font-medium text-gray-500 hover:text-gray-900">
            Help
          </div> -->
          <div v-on:click="signOut" class="section text-base font-medium text-gray-500 hover:text-gray-900">
            Sign Out
          </div>
          <!-- <div v-on:click="toggleGrades" class="section text-base font-medium text-gray-500 hover:text-gray-900">
            Grades
          </div> -->

          <!-- <Popover class="relative" v-slot="{ open }">
            <PopoverButton :class="[open ? 'text-gray-900' : 'text-gray-500', 'group bg-white rounded-md inline-flex items-center text-base font-medium hover:text-gray-900 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500']">
              <span>Account</span>
              <ChevronDownIcon :class="[open ? 'text-gray-600' : 'text-gray-400', 'ml-2 h-5 w-5 group-hover:text-gray-500']" aria-hidden="true" />
            </PopoverButton>

            <transition enter-active-class="transition ease-out duration-200" enter-from-class="opacity-0 translate-y-1" enter-to-class="opacity-100 translate-y-0" leave-active-class="transition ease-in duration-150" leave-from-class="opacity-100 translate-y-0" leave-to-class="opacity-0 translate-y-1">
              <PopoverPanel class="absolute z-10 left-1/2 transform -translate-x-1/2 mt-3 px-2 w-screen max-w-md sm:px-0">
                <div class="rounded-lg shadow-lg ring-1 ring-black ring-opacity-5 overflow-hidden">
                  <div class="relative grid gap-6 bg-white px-5 py-6 sm:gap-8 sm:p-8">
                    <a v-for="item in resources" :key="item.name" :href="item.href" class="-m-3 p-3 flex items-start rounded-lg hover:bg-gray-50">
                      <component :is="item.icon" class="flex-shrink-0 h-6 w-6 text-indigo-600" aria-hidden="true" />
                      <div class="ml-4" v-on:click="toggleAccount">
                        <p class="text-base font-medium text-gray-900">
                          {{ item.name }}
                        </p>
                      </div>
                    </a>
                    <div class="-m-3 p-3 flex items-start rounded-lg hover:bg-gray-50">
                      <component :is="SupportIcon" class="flex-shrink-0 h-6 w-6 text-indigo-600" aria-hidden="true" />
                      <div class="ml-4" v-on:click="toggleAccount">
                        <p class="text-base font-medium text-gray-900 accountSection">
                          Edit Account Information
                        </p>
                      </div>
                    </div>
                     <div class="-m-3 p-3 flex items-start rounded-lg hover:bg-gray-50">
                      <component :is="SupportIcon" class="flex-shrink-0 h-6 w-6 text-indigo-600" aria-hidden="true" />
                      <div class="ml-4" v-on:click="toggleEdit">
                        <p class="text-base font-medium text-gray-900 accountSection">
                          Switch User Mode
                        </p>
                      </div>
                    </div>
                     <div class="-m-3 p-3 flex items-start rounded-lg hover:bg-gray-50">
                      <component :is="SupportIcon" class="flex-shrink-0 h-6 w-6 text-indigo-600" aria-hidden="true" />
                      <div class="ml-4">
                        <p class="text-base font-medium text-gray-900 accountSection">
                          Sign Out
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
              </PopoverPanel>
            </transition>
          </Popover> -->
        </PopoverGroup>
        <div class="hidden md:flex items-center justify-end md:flex-1 lg:w-0">
          <!-- <a href="#" class="whitespace-nowrap text-base font-medium text-gray-500 hover:text-gray-900">
            Sign in
          </a>
          <a href="#" class="ml-8 whitespace-nowrap inline-flex items-center justify-center px-4 py-2 border border-transparent rounded-md shadow-sm text-base font-medium text-white bg-indigo-600 hover:bg-indigo-700">
            Sign up
          </a> -->
        </div>
      </div>
    </div>

    <transition enter-active-class="duration-200 ease-out" enter-from-class="opacity-0 scale-95" enter-to-class="opacity-100 scale-100" leave-active-class="duration-100 ease-in" leave-from-class="opacity-100 scale-100" leave-to-class="opacity-0 scale-95">
      <PopoverPanel focus class="absolute top-0 inset-x-0 p-2 transition transform origin-top-right md:hidden">
        <div class="rounded-lg shadow-lg ring-1 ring-black ring-opacity-5 bg-white divide-y-2 divide-gray-50">
          <div class="pt-5 pb-6 px-5">
            <div class="flex items-center justify-between">
              <div>
                <img class="h-8 w-auto" src="https://tailwindui.com/img/logos/workflow-mark-indigo-600.svg" alt="Workflow" />
              </div>
              <div class="-mr-2">
                <PopoverButton class="bg-white rounded-md p-2 inline-flex items-center justify-center text-gray-400 hover:text-gray-500 hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-indigo-500">
                  <span class="sr-only">Close menu</span>
                  <XIcon class="h-6 w-6" aria-hidden="true" />
                </PopoverButton>
              </div>
            </div>
            <div class="mt-6">
              <nav class="grid gap-y-8">
                <a v-for="item in solutions" :key="item.name" :href="item.href" class="-m-3 p-3 flex items-center rounded-md hover:bg-gray-50">
                  <component :is="item.icon" class="flex-shrink-0 h-6 w-6 text-indigo-600" aria-hidden="true" />
                  <span class="ml-3 text-base font-medium text-gray-900">
                    {{ item.name }}
                  </span>
                </a>
              </nav>
            </div>
          </div>
        </div>
      </PopoverPanel>
    </transition>
  </Popover>
</template>
<style scoped>
.section:hover {
  color: blue;
  cursor: pointer;
}
.accountSection:hover{
  cursor: pointer;
}
</style>
<script>
import { Popover, PopoverButton, PopoverGroup, PopoverPanel } from '@headlessui/vue'
import {
  BookmarkAltIcon,
  ChartBarIcon,
  CursorClickIcon,
  MenuIcon,
  PhoneIcon,
  PlayIcon,
  RefreshIcon,
  ShieldCheckIcon,
  SupportIcon,
  ViewGridIcon,
  XIcon,
} from '@heroicons/vue/outline'
import { ChevronDownIcon } from '@heroicons/vue/solid'

const solutions = [
  {
    name: 'Analytics',
    description: 'Get a better understanding of where your traffic is coming from.',
    href: '#',
    icon: ChartBarIcon,
  },
  {
    name: 'Engagement',
    description: 'Speak directly to your customers in a more meaningful way.',
    href: '#',
    icon: CursorClickIcon,
  },
  { name: 'Security', description: "Your customers' data will be safe and secure.", href: '#', icon: ShieldCheckIcon },
  {
    name: 'Integrations',
    description: "Connect with third-party tools that you're already using.",
    href: '#',
    icon: ViewGridIcon,
  },
  {
    name: 'Automations',
    description: 'Build strategic funnels that will drive your customers to convert',
    href: '#',
    icon: RefreshIcon,
  },
]
const callsToAction = [
  { name: 'Watch Demo', href: '#', icon: PlayIcon },
  { name: 'Contact Sales', href: '#', icon: PhoneIcon },
]
const resources = [
  {
    name: 'Edit Account Information',
    description: 'Change your personal information, username, password, or profile picture',
    href: '#',
    icon: SupportIcon,
  },
  {
    name: 'Switch User View',
    description: 'Switch between student and teacher view',
    href: '#',
    icon: BookmarkAltIcon,
  },
    {
    name: 'Sign Out',
    description: 'Sign out of your account',
    href: '#',
    icon: BookmarkAltIcon,
  },
]
const recentPosts = [
  { id: 1, name: 'Boost your conversion rate', href: '#' },
  { id: 2, name: 'How to use search engine optimization to drive traffic to your site', href: '#' },
  { id: 3, name: 'Improve your customer experience', href: '#' },
]

export default {
  components: {
    Popover,
    PopoverButton,
    PopoverGroup,
    PopoverPanel,
    ChevronDownIcon,
    MenuIcon,
    XIcon,
  },
  setup() {
    return {
      solutions,
      callsToAction,
      resources,
      recentPosts,
    }
  },
  methods:{
    signOut: function(){
      this.$store.dispatch('auth/logout')
      this.$router.push('/login');
    },
    toggleForum: function(){
      this.$router.push({ path: `/board/${this.$route.params.courseId}` })
    },
    toggleTextbook: function(){
      this.$router.push({ path: '/home' })
    },
    toggleHelp: function(){
      this.$router.push({ path: '/help' })
    }
  },
  props: {
    toggleEdit: Function,
    toggleAssignment: Function,
    toggleExam: Function,
    toggleHome: Function,
    toggleAccount: Function,
    toggleGrades: Function,
    accountMode: String,
  },
}
</script>