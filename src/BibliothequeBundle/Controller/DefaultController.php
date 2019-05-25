<?php

namespace BibliothequeBundle\Controller;

use AppBundle\Entity\User;
use BibliothequeBundle\Entity\Livre;
use Symfony\Component\HttpFoundation\Request;

use BibliothequeBundle\Entity\Location;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;

class DefaultController extends Controller
{
    public function indexAction()
    {
        $em = $this->getDoctrine()->getManager();
        $locations = $this->getDoctrine()->getRepository(Location::class)->findLocationEnCours();
        $livres  = $em->getRepository('BibliothequeBundle:Livre')->findAll();

        return $this->render('@Bibliotheque/Default/rendreLivre.html.twig', array(
            'locations' => $locations,
            'livres' => $livres
        ));
    }

    public function home2Action()
    {
        return $this->render('@Bibliotheque/Default/home.html.twig');
    }
}
