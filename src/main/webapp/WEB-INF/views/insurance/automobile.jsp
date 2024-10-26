<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>

</head>
<body>
<jsp:include page="../component/navbar.jsp"/>
</body>


<section class="bg-gray-100">
    <div class="mx-auto max-w-screen-xl px-4 py-16 sm:px-6 lg:px-8">
        <div class="grid grid-cols-1 gap-x-16 gap-y-8 lg:grid-cols-5">
            <div class="lg:col-span-2 lg:py-12">
                <p class="max-w-xl text-lg">
                    At the same time, the fact that we are wholly owned and totally independent from
                    manufacturer and other group control gives you confidence that we will only recommend what
                    is right for you.
                </p>

                <div class="mt-8">
                    <a href="#" class="text-2xl font-bold text-pink-600"> 0151 475 4450 </a>

                    <address class="mt-2 not-italic">282 Kevin Brook, Imogeneborough, CA 58517</address>
                </div>
            </div>

            <div class="rounded-lg bg-white p-8 shadow-lg lg:col-span-3 lg:p-12 relative">
                <c:if test="${not empty message}">
                    <div class="bg-green-200 px-6 py-4 mx-2 my-4 rounded-md text-lg flex items-center mx-auto max-w-lg absolute top-[-30px]" >
                        <span class="text-green-800">${message}.</span>
                    </div>
                </c:if>
                <form action="${pageContext.request.contextPath}/insurance/car" method="post" class="space-y-4">
                    <div>
                        <label class="sr-only" for="driverAge">Age</label>
                        <input
                                class="w-full rounded-lg border-gray-200 p-3 text-sm"
                                placeholder="Driver Age"
                                type="number"
                                id="driverAge"
                                name="driverAge"
                                required
                                min="1"/>
                    </div>

                    <div class="grid grid-cols-1 gap-4 sm:grid-cols-2">
                        <div>
                            <label class="sr-only" for="model">Model</label>
                            <input
                                    class="w-full rounded-lg border-gray-200 p-3 text-sm"
                                    placeholder="Car Model"
                                    type="text"
                                    id="model"
                                    name="model"
                                    required/>
                        </div>

                        <div>
                            <label class="sr-only" for="brand">Brand</label>
                            <input
                                    class="w-full rounded-lg border-gray-200 p-3 text-sm"
                                    placeholder="Car Brand"
                                    type="text"
                                    id="brand"
                                    name="brand"
                                    required/>
                        </div>
                    </div>

                    <div class="grid grid-cols-1 gap-4 text-center sm:grid-cols-2">
                        <div>
                            <label
                                    for="Option1"
                                    class="block w-full cursor-pointer rounded-lg border border-gray-200 p-3 text-gray-600 hover:border-black has-[:checked]:border-black has-[:checked]:bg-black has-[:checked]:text-white"
                                    tabindex="0">
                                <input
                                        class="sr-only"
                                        id="Option1"
                                        type="radio"
                                        name="carType"
                                        value="LUXURY"
                                        required/>
                                <span class="text-sm">LUXURY</span>
                            </label>
                        </div>

                        <div>
                            <label
                                    for="Option2"
                                    class="block w-full cursor-pointer rounded-lg border border-gray-200 p-3 text-gray-600 hover:border-black has-[:checked]:border-black has-[:checked]:bg-black has-[:checked]:text-white"
                                    tabindex="0">
                                <input
                                        class="sr-only"
                                        id="Option2"
                                        type="radio"
                                        name="carType"
                                        value="UTILITY"/>
                                <span class="text-sm">UTILITY</span>
                            </label>
                        </div>
                    </div>

                    <!-- Driver History Section -->
                    <div class="space-y-4">
                        <div>
                            <label class="sr-only" for="driverHistory.accidentCount">Accident Count</label>
                            <input
                                    class="w-full rounded-lg border-gray-200 p-3 text-sm"
                                    placeholder="Number of Accidents"
                                    type="number"
                                    id="driverHistory.accidentCount"
                                    name="driverHistory.accidentCount"
                                    required
                                    min="0"/>
                        </div>

                        <div>
                            <label class="sr-only" for="driverHistory.infractionCount">Infraction Count</label>
                            <input
                                    class="w-full rounded-lg border-gray-200 p-3 text-sm"
                                    placeholder="Number of Infractions"
                                    type="number"
                                    id="driverHistory.infractionCount"
                                    name="driverHistory.infractionCount"
                                    required
                                    min="0"/>
                        </div>

                        <div>
                            <label class="sr-only" for="driverHistory.yearsAccidentFree">Years Accident Free</label>
                            <input
                                    class="w-full rounded-lg border-gray-200 p-3 text-sm"
                                    placeholder="Years Accident Free"
                                    type="number"
                                    id="driverHistory.yearsAccidentFree"
                                    name="driverHistory.yearsAccidentFree"
                                    required
                                    min="0"/>
                        </div>
                    </div>

                    <div class="mt-4">
                        <button
                                type="submit"
                                class="inline-block w-full rounded-lg bg-black px-5 py-3 font-medium text-white sm:w-auto">
                            Send Enquiry
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
</html>
