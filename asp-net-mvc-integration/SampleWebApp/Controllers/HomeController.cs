using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using System.Web.Mvc.Ajax;
using RestSharp;
using RestSharp.Extensions;

namespace SampleWebApp.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        [HttpPost]
        public ActionResult UploadFiles()
        {
            var restClient = new RestClient("http://localhost:5000/api");
            var request = new RestRequest("/upload/index") {Method = Method.POST};
            request.AddHeader("Content-Type", "multipart/form-data");
            request.AddHeader("Accept", "application/json");
            for (var index = 0; index < Request.Files.Count; index++)
            {
                var file = Request.Files[index];
                request.AddFile(file.FileName, file.InputStream.ReadAsBytes(), file.FileName);
            }

            var result = restClient.ExecuteAsync(request, response =>
            {
                Debug.WriteLine(response);
            });
                
            return new HttpStatusCodeResult(HttpStatusCode.OK);
        }
    }
}