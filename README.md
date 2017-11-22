# FragmentSampleApp

so this is a small app that covers some part of fragment.
so a fragment is small portion of a user interface of the Activity.
we may call them "the mini activities" because the are a mini activity within the activity as they have their own life cycle.
life cycle of fragment consists of more methods as compared to the lifecycle of the activity.
the include onCreate(),onCreateView(),onActivityFinished() and even onResume() and onPause(),onDestroy(),onDestroyView() etc.
but important one for us right now is the onCreateView().
so fragment has to be displayed inside another activity(host activity) to be visible.

how we created fragment in this project:
                   we created out main Activity that will display or host these three fragments.
                   now the create a fragment we first created a simple layout for fragment in xml ,which in our case is a simple imageview.
                   now create a class and extend it from fragment.
                   and in this class override the onCreateView() method.
                   in onCreateView() we inflate the fragment layout ,add over image resource and returns the view.
                   now in mainActivity getSupportManager() and add frament objects to its using transaction().add() method.
                   the transaction.add() method takes in the id of the container in the mainActivity and the fragment object.
