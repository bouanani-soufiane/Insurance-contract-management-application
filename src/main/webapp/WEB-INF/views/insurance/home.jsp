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
                    here
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
                        <span class="text-red-800">${error}.</span>
                    </div>
                </c:if>
                <form action="${pageContext.request.contextPath}/insurance/home" method="post" class="space-y-4">
                    <div>
                        <label class="sr-only" for="propertyValue">Property Value</label>
                        <input
                                class="w-full rounded-lg border-gray-200 p-3 text-sm"
                                placeholder="Property Value"
                                type="number"
                                id="propertyValue"
                                name="propertyValue"
                                required
                                min="1"/>
                    </div>

                    <fieldset class="flex flex-wrap gap-3">
                        <legend class="sr-only">Color</legend>

                        <div>
                            <label
                                    for="ColorBlack"
                                    class="flex cursor-pointer items-center justify-center rounded-md border border-gray-100 bg-white px-3 py-2 text-gray-900 hover:border-gray-200 has-[:checked]:border-blue-500 has-[:checked]:bg-blue-500 has-[:checked]:text-white"
                            >
                                <input
                                        type="radio"
                                        name="propertyType"
                                        value="HOUSE"
                                        id="ColorBlack"
                                        class="sr-only"
                                        checked
                                />

                                <p class="text-sm font-medium">HOUSE</p>
                            </label>
                        </div>

                        <div>
                            <label
                                    for="ColorRed"
                                    class="flex cursor-pointer items-center justify-center rounded-md border border-gray-100 bg-white px-3 py-2 text-gray-900 hover:border-gray-200 has-[:checked]:border-blue-500 has-[:checked]:bg-blue-500 has-[:checked]:text-white"
                            >
                                <input type="radio" name="propertyType" value="VILLA" id="ColorRed" class="sr-only"/>

                                <p class="text-sm font-medium">VILLA</p>
                            </label>
                        </div>

                        <div>
                            <label
                                    for="ColorBlue"
                                    class="flex cursor-pointer items-center justify-center rounded-md border border-gray-100 bg-white px-3 py-2 text-gray-900 hover:border-gray-200 has-[:checked]:border-blue-500 has-[:checked]:bg-blue-500 has-[:checked]:text-white"
                            >
                                <input type="radio" name="propertyType" value="APARTMENT" id="ColorBlue"
                                       class="sr-only"/>

                                <p class="text-sm font-medium">APARTMENT</p>
                            </label>
                        </div>

                        <div>
                            <label
                                    for="ColorGold"
                                    class="flex cursor-pointer items-center justify-center rounded-md border border-gray-100 bg-white px-3 py-2 text-gray-900 hover:border-gray-200 has-[:checked]:border-blue-500 has-[:checked]:bg-blue-500 has-[:checked]:text-white"
                            >
                                <input type="radio" name="propertyType" value="COMMERCIAL" id="ColorGold"
                                       class="sr-only"/>

                                <p class="text-sm font-medium">COMMERCIAL</p>
                            </label>
                        </div>
                    </fieldset>
                    <div>
                        <label class="sr-only" for="propertyValue">street</label>
                        <input
                                class="w-full rounded-lg border-gray-200 p-3 text-sm"
                                placeholder="street"
                                type="text"
                                id="street"
                                name="street"
                                required
                        />
                    </div>
                    <div>
                        <label class="sr-only" for="propertyValue">city</label>
                        <input
                                class="w-full rounded-lg border-gray-200 p-3 text-sm"
                                placeholder="city"
                                type="text"
                                id="city"
                                name="city"
                                required
                        />
                    </div>

                    <fieldset class="flex flex-wrap gap-3">
                        <legend class="sr-only">Color</legend>

                        <div>
                            <label
                                    for="LOW_RISK"
                                    class="flex cursor-pointer items-center justify-center rounded-md border border-gray-100 bg-white px-3 py-2 text-gray-900 hover:border-gray-200 has-[:checked]:border-blue-500 has-[:checked]:bg-blue-500 has-[:checked]:text-white"
                            >
                                <input
                                        type="radio"
                                        name="riskZone"
                                        value="LOW_RISK"
                                        id="LOW_RISK"
                                        class="sr-only"
                                        checked
                                />

                                <p class="text-sm font-medium">LOW RISK</p>
                            </label>
                        </div>

                        <div>
                            <label
                                    for="MEDIUM_RISK"
                                    class="flex cursor-pointer items-center justify-center rounded-md border border-gray-100 bg-white px-3 py-2 text-gray-900 hover:border-gray-200 has-[:checked]:border-blue-500 has-[:checked]:bg-blue-500 has-[:checked]:text-white"
                            >
                                <input type="radio" name="riskZone" value="MEDIUM_RISK" id="MEDIUM_RISK" class="sr-only"/>

                                <p class="text-sm font-medium">MEDIUM RISK</p>
                            </label>
                        </div>

                        <div>
                            <label
                                    for="HIGH_RISK"
                                    class="flex cursor-pointer items-center justify-center rounded-md border border-gray-100 bg-white px-3 py-2 text-gray-900 hover:border-gray-200 has-[:checked]:border-blue-500 has-[:checked]:bg-blue-500 has-[:checked]:text-white"
                            >
                                <input type="radio" name="riskZone" value="HIGH_RISK" id="HIGH_RISK"
                                       class="sr-only"/>

                                <p class="text-sm font-medium">HIGH RISK</p>
                            </label>
                        </div>

                    </fieldset>
                    <fieldset class="grid grid-cols-2 gap-4 mt-4">
                        <legend class="sr-only">Security Features</legend>

                        <div>
                            <label
                                    for="HasCamerasTrue"
                                    class="block cursor-pointer rounded-lg border border-gray-100 bg-white p-4 text-sm font-medium shadow-sm hover:border-gray-200 has-[:checked]:border-blue-500 has-[:checked]:ring-1 has-[:checked]:ring-blue-500"
                            >
                                <div>
                                    <p class="text-gray-700">Has Cameras</p>
                                    <p class="mt-1 text-gray-900">True</p>
                                </div>
                                <input
                                        type="radio"
                                        name="hasCameras"
                                        value="true"
                                        id="HasCamerasTrue"
                                        class="sr-only"
                                />
                            </label>
                        </div>

                        <div>
                            <label
                                    for="HasCamerasFalse"
                                    class="block cursor-pointer rounded-lg border border-gray-100 bg-white p-4 text-sm font-medium shadow-sm hover:border-gray-200 has-[:checked]:border-blue-500 has-[:checked]:ring-1 has-[:checked]:ring-blue-500"
                            >
                                <div>
                                    <p class="text-gray-700">Has Cameras</p>
                                    <p class="mt-1 text-gray-900">False</p>
                                </div>
                                <input
                                        type="radio"
                                        name="hasCameras"
                                        value="false"
                                        id="HasCamerasFalse"
                                        class="sr-only"
                                />
                            </label>
                        </div>
                    </fieldset>
                    <fieldset class="grid grid-cols-2 gap-4 mt-4">
                        <legend class="sr-only">Alarm Feature</legend>

                        <div>
                            <label
                                    for="HasAlarmTrue"
                                    class="block cursor-pointer rounded-lg border border-gray-100 bg-white p-4 text-sm font-medium shadow-sm hover:border-gray-200 has-[:checked]:border-blue-500 has-[:checked]:ring-1 has-[:checked]:ring-blue-500"
                            >
                                <div>
                                    <p class="text-gray-700">Has Alarm</p>
                                    <p class="mt-1 text-gray-900">True</p>
                                </div>
                                <input
                                        type="radio"
                                        name="hasAlarm"
                                        value="true"
                                        id="HasAlarmTrue"
                                        class="sr-only"
                                />
                            </label>
                        </div>

                        <div>
                            <label
                                    for="HasAlarmFalse"
                                    class="block cursor-pointer rounded-lg border border-gray-100 bg-white p-4 text-sm font-medium shadow-sm hover:border-gray-200 has-[:checked]:border-blue-500 has-[:checked]:ring-1 has-[:checked]:ring-blue-500"
                            >
                                <div>
                                    <p class="text-gray-700">Has Alarm</p>
                                    <p class="mt-1 text-gray-900">False</p>
                                </div>
                                <input
                                        type="radio"
                                        name="hasAlarm"
                                        value="false"
                                        id="HasAlarmFalse"
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
