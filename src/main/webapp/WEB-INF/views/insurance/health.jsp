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
                    <div class="bg-green-200 px-6 py-4 mx-2 my-4 rounded-md text-lg flex items-center mx-auto max-w-lg absolute top-[-30px]">
                        <span class="text-green-800">${message}.</span>
                    </div>
                </c:if>
                <c:if test="${not empty error}">
                    <div class="bg-green-200 px-6 py-4 mx-2 my-4 rounded-md text-lg flex items-center mx-auto max-w-lg absolute top-[-30px]">
                        <span class="text-green-800">${error}.</span>
                    </div>
                </c:if>
                <form action="${pageContext.request.contextPath}/insurance/health" method="post" class="space-y-4">
                    <div>
                        <label class="sr-only" for="age">age</label>
                        <input
                                class="w-full rounded-lg border-gray-200 p-3 text-sm"
                                placeholder="age"
                                type="number"
                                id="age"
                                name="age"
                                required
                                min="1"/>
                    </div>
                    <fieldset class="grid grid-cols-2 gap-4 mt-4">
                        <legend class="sr-only">Chronic Conditions</legend>

                        <div>
                            <label
                                    for="HasChronicConditionsTrue"
                                    class="block cursor-pointer rounded-lg border border-gray-100 bg-white p-4 text-sm font-medium shadow-sm hover:border-gray-200 has-[:checked]:border-blue-500 has-[:checked]:ring-1 has-[:checked]:ring-blue-500"
                            >
                                <div>
                                    <p class="text-gray-700">Has Chronic Conditions</p>
                                    <p class="mt-1 text-gray-900">True</p>
                                </div>
                                <input
                                        type="radio"
                                        name="hasChronicConditions"
                                        value="true"
                                        id="HasChronicConditionsTrue"
                                        class="sr-only"
                                />
                            </label>
                        </div>

                        <div>
                            <label
                                    for="HasChronicConditionsFalse"
                                    class="block cursor-pointer rounded-lg border border-gray-100 bg-white p-4 text-sm font-medium shadow-sm hover:border-gray-200 has-[:checked]:border-blue-500 has-[:checked]:ring-1 has-[:checked]:ring-blue-500"
                            >
                                <div>
                                    <p class="text-gray-700">Has Chronic Conditions</p>
                                    <p class="mt-1 text-gray-900">False</p>
                                </div>
                                <input
                                        type="radio"
                                        name="hasChronicConditions"
                                        value="false"
                                        id="HasChronicConditionsFalse"
                                        class="sr-only"
                                />
                            </label>
                        </div>
                    </fieldset>
                    <fieldset class="grid grid-cols-2 gap-4 mt-4">
                        <legend class="sr-only">Coverage Type</legend>

                        <div>
                            <label
                                    for="CoverageTypeBasic"
                                    class="block cursor-pointer rounded-lg border border-gray-100 bg-white p-4 text-sm font-medium shadow-sm hover:border-gray-200 has-[:checked]:border-blue-500 has-[:checked]:ring-1 has-[:checked]:ring-blue-500"
                            >
                                <div>
                                    <p class="text-gray-700">Coverage Type</p>
                                    <p class="mt-1 text-gray-900">Basic</p>
                                </div>
                                <input
                                        type="radio"
                                        name="coverageType"
                                        value="BASIC"
                                        id="CoverageTypeBasic"
                                        class="sr-only"
                                />
                            </label>
                        </div>

                        <div>
                            <label
                                    for="CoverageTypePremium"
                                    class="block cursor-pointer rounded-lg border border-gray-100 bg-white p-4 text-sm font-medium shadow-sm hover:border-gray-200 has-[:checked]:border-blue-500 has-[:checked]:ring-1 has-[:checked]:ring-blue-500"
                            >
                                <div>
                                    <p class="text-gray-700">Coverage Type</p>
                                    <p class="mt-1 text-gray-900">Premium</p>
                                </div>
                                <input
                                        type="radio"
                                        name="coverageType"
                                        value="PREMIUM"
                                        id="CoverageTypePremium"
                                        class="sr-only"
                                />
                            </label>
                        </div>
                    </fieldset>


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
