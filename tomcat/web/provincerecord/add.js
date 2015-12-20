/**
 * Created by blindeagle on 15-12-13.
 */
$(".addCityItem").click(function() {
    var cityCount = $(".cityCount").val();
    cityCount++;
    $(".cityCount").val(cityCount);
    $(".city").last().append("<hr color='red'/><input type='button' value='+' class='addCountyItem'/>" +
        "<input type='hidden' class='cityProvinceId' value='${(CityRecord"+cityCount+".id)!}' />" +
        "<input type='hidden' class='cityProvinceRfcID' value='${(ProvinceRecord"+cityCount+".ProvinceRfcID)!}' />" +
        "<input type='hidden' class='citySubjectID' value='${(ProvinceRecord"+cityCount+".SubjectID)!}' />" +
        "<input type='hidden' class='cityProjectID' value='${(ProvinceRecord"+cityCount+".ProjectID)!}' />" +
        "<div><label>市ID</label>" +
        "<input type='text' class='cityID' />${cityIDMsg!}" +
        "</div><div><label>市预算</label>" +
        "<input type='text' class='cityBudget' />${cityBudgetMsg!}" +
        "</div><input type='hidden' class='cityCost' value='0' />" +
        "<div class='county'></div>");
    $(".city").last().after("<div class='city'></div>");
});

$(".province").on("click", ".addCountyItem", function() {
    var countyCount = $(".countyCount").val();
    countyCount++;
    $(".countyCount").val(countyCount);
    $(this).parent(".city").find(".countyCount").val(countyCount)
    $(this).parent(".city").find(".county").last().append("<hr/><input type='hidden' class='id' value='${(CountyRecord"+countyCount+".id)!}' />" +
        "<input type='hidden' class='countyProvinceRfcID' value='${(ProvinceRecord1.ProvinceRfcID)!}' />" +
        "<input type='hidden' class='countySubjectID' value='${(ProvinceRecord"+countyCount+".SubjectID)!}' />" +
        "<input type='hidden' class='countyProjectID' value='${(ProvinceRecord"+countyCount+".ProjectID)!}' />" +
        "<input type='hidden' class='countyCityID' value='${(CityRecord"+countyCount+".CityID)!}' />" +
        "<div><label>县ID</label>" +
        "<input type='text' class='countyId' />${cityBudgetMsg!}" +
        "</div><div><label>县预算</label>" +
        "<input type='text' class='countyBudget' />${cityBudgetMsg!}" +
        "</div><input type='hidden' class='countyCost' value='0' />");
    $(this).parent(".city").find(".county").last().after("<div class='county'></div>");
});

$(".tijiao").click(function() {
    // 获取省级信息
    var $province = $(".province");
    var proPublic = "ProvinceRecord.";
    var id = $province.find(".provinceId").val();
    var ProvinceRfcID = $province.find(".ProvinceRfcID").val();
    var SubjectID = $province.find(".SubjectID").val();
    var ProjectID = $province.find(".ProjectID").val();
    var Budget = $province.find(".Budget").val();
    var Cost = $province.find(".Cost").val();
    var provinceStr = (proPublic+"id="+id) + "&" + (proPublic+"ProvinceRfcID="+ProvinceRfcID) + "&" + (proPublic+"SubjectID="+SubjectID)
        + "&" + (proPublic+"ProjectID="+ProjectID) + "&" + (proPublic+"Budget="+Budget) + "&" + (proPublic+"Cost="+Cost) + "&";
    alert(provinceStr);

    // 获取市级信息
    var $city = $(".city");
    var cityStrs="", cityStr;
    var cityPublic = "CityRecord";
    var i = 1;
    $city.each(function() {
        if ($(this).html() != "") {
            var id = $(this).find(".cityProvinceId").val();
            var ProvinceRfcID = $(this).find(".cityProvinceRfcID").val();
            var SubjectID = $(this).find(".citySubjectID").val();
            var ProjectID = $(this).find(".cityProjectID").val();
            var CityID = $(this).find(".cityID").val();
            var Budget = $(this).find(".cityBudget").val();
            var Cost = $(this).find(".cityCost").val();
            cityStr = (cityPublic+i+".id="+id) + "&" + (cityPublic+i+".ProvinceRfcID="+ProvinceRfcID) + "&" +
                (cityPublic+i+".SubjectID="+SubjectID) + "&" + (cityPublic+i+".ProjectID="+ProjectID) + "&" +
                (cityPublic+i+".CityID="+CityID) + "&" + (cityPublic+i+".Budget="+Budget) + "&" +
                (cityPublic+i+".Cost="+Cost) + "&";
            cityStrs += cityStr;
            i++;
        }
    });
    alert(cityStrs);

    // 获取县级信息
    var $county = $(".county");
    var countyStrs="", countyStr;
    var countyPublic = "CountyRecord";
    var i = 1;
    $county.each(function() {
        if ($(this).html() != "") {
            var id = $(this).find(".id").val();
            var ProvinceRfcID = $(this).find(".countyProvinceRfcID").val();
            var SubjectID = $(this).find(".countySubjectID").val();
            var ProjectID = $(this).find(".countyProjectID").val();
            var CityID = $(this).find(".countyCityID").val();
            var CountyID = $(this).find(".countyId").val();
            var Budget = $(this).find(".countyBudget").val();
            var Cost = $(this).find(".countyCost").val();
            countyStr = (countyPublic+i+".id="+id) + "&" + (countyPublic+i+".ProvinceRfcID="+ProvinceRfcID) + "&" +
                (countyPublic+i+".SubjectID="+SubjectID) + "&" + (countyPublic+i+".ProjectID="+ProjectID) + "&" +
                (countyPublic+i+".CityID="+CityID) + "&" + "&" + (countyPublic+i+".CountyID="+CountyID) + "&" +
                (countyPublic+i+".Budget="+Budget) + "&" + (countyPublic+i+".Cost="+Cost) + "&";
            countyStrs += countyStr;
            i++;
        }
    });
    alert(countyStrs);

    // 提交时间
    var RecordTime = new Date();
    alert(RecordTime.toLocaleString());

    var data = provinceStr + cityStrs + countyStrs;
    window.location.href = "/provincerecord/save" + data + "RecordTime:" + RecordTime.toLocaleString();

});