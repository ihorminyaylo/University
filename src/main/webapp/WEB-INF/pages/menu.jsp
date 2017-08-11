<ul class="nav nav-pills">
        <li role="presentation"><a href="/students">Students</a></li>
        <li role="presentation"><a href="/subjects">Subjects</a></li>
        <li role="presentation"><a href="/lessons">Lessons</a></li>
        <li role="presentation"><a href="/export">Export(JSON)</a></li>
        <form class="navbar-form navbar-left" role="search" action="/LogoutServlet" method="post">
            <button type="submit" class="btn btn-default">Log out</button>
        </form>
</ul>
    <%--<div class="container-fluid">
        <div class="navbar-header"><a class="navbar-brand" href="/students">Students</a>
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-menubuilder"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse navbar-menubuilder">
            <ul class="nav navbar-nav navbar-left">
                <jsp:include page="LoginSuccess.jsp"/>
                <li><a href="/subjects">Subjects</a>
                </li>
                <li><a href="/lessons">Lessons</a>
                </li>
                <li><a href="/import">Import(JSON)</a>
                </li>
                <li><a href="/export">Export(JSON)</a>
                </li>
                <li><a>
                    <form action="LogoutServlet" method="post">
                        <button type="submit" class="btn btn-default btn-sm">
                            <span class="glyphicon glyphicon-log-out"></span> Log out
                        </button>
                    </form>
                </a>
                </li>
            </ul>
        </div>
    </div>--%>
</div>