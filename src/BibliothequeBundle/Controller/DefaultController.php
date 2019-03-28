<?php

namespace BibliothequeBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('@Bibliotheque/Default/index.html.twig');
    }

    public function home2Action()
    {
        return $this->render('@Bibliotheque/Default/home.html.twig');
    }
}
