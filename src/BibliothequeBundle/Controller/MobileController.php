<?php

namespace BibliothequeBundle\Controller;

use AppBundle\AppBundle;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Serializer\Normalizer\ObjectNormalizer;
use Symfony\Component\Serializer\Serializer;

use AppBundle\Entity\User;
use BibliothequeBundle\Entity\CommentaireLivre;
use BibliothequeBundle\Entity\Livre;
use BibliothequeBundle\Entity\Location;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Component\HttpFoundation\File\UploadedFile;

class MobileController extends Controller
{
    public function AfficherLivresAction()
{
    $tasks = $this->getDoctrine()->getManager()
        ->getRepository('BibliothequeBundle:Livre')
        ->findAll();
    $serializer = new Serializer([new ObjectNormalizer()]);
    $formatted = $serializer->normalize($tasks);
    return new JsonResponse($formatted);
}
    public function AfficherLivreAction(Request $request)
    {
        $tasks = $this->getDoctrine()->getManager()
            ->getRepository('BibliothequeBundle:Livre')->getLivresByTitreOrDesc($request->get("key"));
        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($tasks);
        return new JsonResponse($formatted);
    }

    public function louerAction(Request $request)
    {
        $em = $this->getDoctrine()->getManager();
        $locataire=$em->getRepository("AppBundle:User")->find($request->get("iduser"));
        $livre = $em->getRepository("BibliothequeBundle:Livre")->find($request->get("idl"));
        $dated = new \DateTime($request->get("dated"));
        $datef = new \DateTime($request->get("datef"));
            $livre->setQuantite($livre->getQuantite() - 1);
            $location = new Location();
            $location->setDateLocation($dated);
            $location->setDateRetour($datef);
            $location->setLivre($livre);
            $location->setEtat("En cours");
            $location->setLocataire($locataire);
            $em = $this->getDoctrine()->getManager();
            $em->persist($location);
            $em->flush();

        $serializer = new Serializer([new ObjectNormalizer()]);
        $formatted = $serializer->normalize($location);
        return new JsonResponse($formatted);        }

public function AfficherCommentaireAction(Request $request){
    $em = $this->getDoctrine()->getManager();
    $Comm = $em->getRepository('BibliothequeBundle:CommentaireLivre')->CommentaireLivreId($request->get("idl"));

    $serializer = new Serializer([new ObjectNormalizer()]);
    $formatted = $serializer->normalize($Comm);
    return new JsonResponse($formatted);
}
public function AjoutCommentaireAction(Request $request){

    $em = $this->getDoctrine()->getManager();
    $livre = $em->getRepository("BibliothequeBundle:Livre")->find($request->get("idl"));
    $locataire=$em->getRepository("AppBundle:User")->find($request->get("iduser"));
    $commentaire = new CommentaireLivre();
    $commentaire->setLocataire($locataire);
    $commentaire->setLivre($livre);

    $commentaire->setCommentaire($request->get("com"));
        $em->persist($commentaire);
        $em->flush();
    $serializer = new Serializer([new ObjectNormalizer()]);
    $formatted = $serializer->normalize($commentaire);
    return new JsonResponse($formatted);
}
public function DeleteCommentaireAction(Request $request){
    $em = $this->getDoctrine()->getManager();
    $Comm = $em->getRepository('BibliothequeBundle:CommentaireLivre')->find($request->get("idc"));
    $em->remove($Comm);
    $em->flush();
    $serializer = new Serializer([new ObjectNormalizer()]);
    $formatted = $serializer->normalize($Comm);
    return new JsonResponse($formatted);
}
public function AfficherMesLocationAction(Request $request){
    $locations = $this->getDoctrine()->getRepository(Location::class)->LocationEnCoursParUSername($request->get("username"));
    $serializer = new Serializer([new ObjectNormalizer()]);
    $formatted = $serializer->normalize($locations);
    return new JsonResponse($formatted);
}
public function AnnulerLocationAction(Request $request){
    $em = $this->getDoctrine()->getManager();
    $locations=new Location();
    $locations = $this->getDoctrine()->getRepository(Location::class)->find($request->get("idl"));
    $locations->setEtat("Annuler");
    $em->persist($locations);
    $em->flush();
    $serializer = new Serializer([new ObjectNormalizer()]);
    $formatted = $serializer->normalize($locations);
    return new JsonResponse($formatted);

}
public function StatAction(Request $request){
    $em = $this->getDoctrine()->getManager();
    $livre= $em->getRepository('BibliothequeBundle:Location')->GetStat();
    $serializer = new Serializer([new ObjectNormalizer()]);
    $formatted = $serializer->normalize($livre);
    return new JsonResponse($formatted);
}

}

